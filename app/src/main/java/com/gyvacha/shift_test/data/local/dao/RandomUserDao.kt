package com.gyvacha.shift_test.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.gyvacha.shift_test.data.local.entities.RandomUserEntity

@Dao
interface RandomUserDao {

    @Query("SELECT * FROM random_users")
    fun pagingSource(): PagingSource<Int, RandomUserEntity>

    @Upsert
    suspend fun insertAll(users: List<RandomUserEntity>)

    @Query("SELECT * FROM random_users WHERE uuid = :id")
    suspend fun getById(id: String): RandomUserEntity

    @Query("DELETE FROM random_users")
    suspend fun clearAll()

    @Query("SELECT COUNT(*) FROM random_users")
    suspend fun count(): Int
}