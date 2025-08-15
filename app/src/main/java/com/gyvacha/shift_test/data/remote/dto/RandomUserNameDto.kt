package com.gyvacha.shift_test.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RandomUserNameDto(
    val first: String,
    val last: String,
    val title: String
)