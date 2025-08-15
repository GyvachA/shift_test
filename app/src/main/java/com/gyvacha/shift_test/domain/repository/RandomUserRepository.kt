package com.gyvacha.shift_test.domain.repository

import androidx.paging.PagingData
import com.gyvacha.shift_test.domain.model.RandomUser
import kotlinx.coroutines.flow.Flow

interface RandomUserRepository {

    fun getUsers(pageSize: Int): Flow<PagingData<RandomUser>>
    suspend fun getUser(id: String): RandomUser
}