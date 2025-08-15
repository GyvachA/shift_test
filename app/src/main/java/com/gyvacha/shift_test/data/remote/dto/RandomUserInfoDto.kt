package com.gyvacha.shift_test.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RandomUserInfoDto(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)