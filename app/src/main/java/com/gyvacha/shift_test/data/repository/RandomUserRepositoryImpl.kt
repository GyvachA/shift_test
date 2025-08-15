package com.gyvacha.shift_test.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.gyvacha.shift_test.data.local.ShiftDatabase
import com.gyvacha.shift_test.data.paging.RandomUserRemoteMediator
import com.gyvacha.shift_test.data.remote.RandomUserApi
import com.gyvacha.shift_test.domain.model.RandomUser
import com.gyvacha.shift_test.domain.model.toDomain
import com.gyvacha.shift_test.domain.repository.RandomUserRepository
import com.gyvacha.shift_test.utils.PreferenceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RandomUserRepositoryImpl @Inject constructor(
    private val api: RandomUserApi,
    private val prefs: PreferenceManager,
    private val db: ShiftDatabase
) : RandomUserRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getUsers(
        pageSize: Int,
    ): Flow<PagingData<RandomUser>> {
        val mediator = RandomUserRemoteMediator(
            api = api,
            pageSize = pageSize,
            db = db,
            prefs = prefs
        )
        return Pager(
            config = PagingConfig(
                pageSize = pageSize,
                initialLoadSize = pageSize,
                enablePlaceholders = true
            ),
            remoteMediator = mediator,
            pagingSourceFactory = { db.randomUserDao().pagingSource() }
        ).flow
            .map { pagingData ->
                pagingData.map {
                    it.toDomain()
                }
            }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun getUser(id: String): RandomUser {
        return withContext(Dispatchers.IO) {
            db.randomUserDao().getById(id).toDomain()
        }
    }
}