package com.gyvacha.shift_test.domain.model

import com.gyvacha.shift_test.data.local.entities.RandomUserLoginEmbeddable
import com.gyvacha.shift_test.data.remote.dto.RandomUserLoginDto

data class RandomUserLogin(
    val md5: String,
    val password: String,
    val salt: String,
    val sha1: String,
    val sha256: String,
    val username: String,
    val uuid: String
)

fun RandomUserLogin.toDto(): RandomUserLoginDto {
    return RandomUserLoginDto(
        md5 = md5,
        password = password,
        salt = salt,
        sha1 = sha1,
        sha256 = sha256,
        username = username,
        uuid = uuid
    )
}

fun RandomUserLoginDto.toDomain(): RandomUserLogin {
    return RandomUserLogin(
        md5 = md5,
        password = password,
        salt = salt,
        sha1 = sha1,
        sha256 = sha256,
        username = username,
        uuid = uuid
    )
}

fun RandomUserLoginDto.toEmbeddable(): RandomUserLoginEmbeddable {
    return RandomUserLoginEmbeddable(
        md5 = md5,
        password = password,
        salt = salt,
        sha1 = sha1,
        sha256 = sha256,
        username = username,
        uuid = uuid
    )
}

fun RandomUserLoginEmbeddable.toDomain(): RandomUserLogin {
    return RandomUserLogin(
        md5 = md5,
        password = password,
        salt = salt,
        sha1 = sha1,
        sha256 = sha256,
        username = username,
        uuid = uuid
    )
}