package com.gyvacha.shift_test.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RandomUserStreetDto(
    val name: String,
    val number: Int
)