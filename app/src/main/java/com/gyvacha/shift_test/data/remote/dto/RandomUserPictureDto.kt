package com.gyvacha.shift_test.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RandomUserPictureDto(
    val large: String,
    val medium: String,
    val thumbnail: String
)