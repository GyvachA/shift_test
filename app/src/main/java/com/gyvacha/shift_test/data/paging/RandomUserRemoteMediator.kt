package com.gyvacha.shift_test.data.paging

import androidx.paging.*
import androidx.room.withTransaction
import com.gyvacha.shift_test.data.local.ShiftDatabase
import com.gyvacha.shift_test.data.local.entities.RandomUserEntity
import com.gyvacha.shift_test.data.local.entities.RemoteKeysEntity
import com.gyvacha.shift_test.data.remote.RandomUserApi
import com.gyvacha.shift_test.domain.model.toEntity
import com.gyvacha.shift_test.utils.PreferenceManager

@OptIn(ExperimentalPagingApi::class)
class RandomUserRemoteMediator(
    private val api: RandomUserApi,
    private val db: ShiftDatabase,
    private val prefs: PreferenceManager,
    private val pageSize: Int = 20
) : RemoteMediator<Int, RandomUserEntity>() {

    private val userDao = db.randomUserDao()
    private val keysDao = db.remoteKeysDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, RandomUserEntity>
    ): MediatorResult {
        return try {
            val page = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> {
                    val firstItem = state.firstItemOrNull()
                    val key = firstItem?.let { keysDao.remoteKeysUserId(it.uuid) }
                    key?.prevKey ?: return MediatorResult.Success(endOfPaginationReached = true)
                }
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull() ?: state.pages.lastOrNull()?.data?.lastOrNull()
                    val key = lastItem?.let { keysDao.remoteKeysUserId(it.uuid) }
                    key?.nextKey ?: return MediatorResult.Success(endOfPaginationReached = false)
                }
            }

            val response = api.getUsers(results = pageSize, page = page, seed = prefs.seed)
            val entities = response.results.map { it.toEntity() }

            if (prefs.seed.isNullOrEmpty()) prefs.seed = response.info.seed
            val endReached = entities.isEmpty()
            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    keysDao.clearRemoteKeys()
                    userDao.clearAll()
                    prefs.removeSeedPref()
                }

                val prevKey = if (page == 1) null else page - 1
                val nextKey = if (endReached) null else page + 1

                keysDao.insertAll(entities.map { RemoteKeysEntity(it.uuid, prevKey, nextKey) })
                userDao.insertAll(entities)
            }

            MediatorResult.Success(endOfPaginationReached = endReached)
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

    override suspend fun initialize(): InitializeAction {
        return if (userDao.count() > 0) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }
}
