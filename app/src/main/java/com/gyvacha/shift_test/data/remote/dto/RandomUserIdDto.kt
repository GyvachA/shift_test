package com.gyvacha.shift_test.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RandomUserIdDto(
    val name: String = "",
    val value: String = ""
)