package com.gyvacha.shift_test.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RandomUserResponseDto(
    val info: RandomUserInfoDto,
    val results: List<RandomUserDto>
)