package com.gyvacha.shift_test.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RandomUserCoordinatesDto(
    val latitude: String,
    val longitude: String
)