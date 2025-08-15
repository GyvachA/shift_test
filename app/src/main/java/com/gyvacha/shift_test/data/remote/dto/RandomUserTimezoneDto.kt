package com.gyvacha.shift_test.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RandomUserTimezoneDto(
    val description: String,
    val offset: String
)