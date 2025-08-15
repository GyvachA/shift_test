package com.gyvacha.shift_test.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RandomUserDobDto(
    val age: Int,
    val date: String
)