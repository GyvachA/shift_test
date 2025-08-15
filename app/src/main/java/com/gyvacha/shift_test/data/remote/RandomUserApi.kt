package com.gyvacha.shift_test.data.remote

import com.gyvacha.shift_test.data.remote.dto.RandomUserResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserApi {
    @GET("api/")
    suspend fun getUsers(
        @Query("results") results: Int = 20,
        @Query("page") page: Int = 1,
        @Query("seed") seed: String? = null
    ): RandomUserResponseDto
}