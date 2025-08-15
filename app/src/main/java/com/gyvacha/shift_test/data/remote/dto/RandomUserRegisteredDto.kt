package com.gyvacha.shift_test.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RandomUserRegisteredDto(
    val age: Int,
    val date: String
)