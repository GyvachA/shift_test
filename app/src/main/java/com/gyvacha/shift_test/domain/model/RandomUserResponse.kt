package com.gyvacha.shift_test.domain.model

import com.gyvacha.shift_test.data.remote.dto.RandomUserResponseDto

data class RandomUserResponse(
    val info: RandomUserInfo,
    val results: List<RandomUser>
)

fun RandomUserResponse.toDto(): RandomUserResponseDto {
    return RandomUserResponseDto(
        info = info.toDto(),
        results = results.map { it.toDto() }
    )
}

fun RandomUserResponseDto.toDomain(): RandomUserResponse {
    return RandomUserResponse(
        info = info.toDomain(),
        results = results.map { it.toDomain() }
    )
}
