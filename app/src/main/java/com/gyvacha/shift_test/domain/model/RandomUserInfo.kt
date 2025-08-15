package com.gyvacha.shift_test.domain.model

import com.gyvacha.shift_test.data.remote.dto.RandomUserInfoDto

data class RandomUserInfo(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)

fun RandomUserInfo.toDto(): RandomUserInfoDto {
    return RandomUserInfoDto(
        page = page,
        results = results,
        seed = seed,
        version = version
    )
}

fun RandomUserInfoDto.toDomain(): RandomUserInfo {
    return RandomUserInfo(
        page = page,
        results = results,
        seed = seed,
        version = version
    )
}
