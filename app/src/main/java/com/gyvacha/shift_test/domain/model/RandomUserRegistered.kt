package com.gyvacha.shift_test.domain.model

import com.gyvacha.shift_test.data.local.entities.RandomUserRegisteredEmbeddable
import com.gyvacha.shift_test.data.remote.dto.RandomUserRegisteredDto

data class RandomUserRegistered(
    val age: Int,
    val date: String
)

fun RandomUserRegistered.toDto(): RandomUserRegisteredDto {
    return RandomUserRegisteredDto(
        age = age,
        date = date
    )
}

fun RandomUserRegisteredDto.toDomain(): RandomUserRegistered {
    return RandomUserRegistered(
        age = age,
        date = date
    )
}

fun RandomUserRegisteredDto.toEmbeddable(): RandomUserRegisteredEmbeddable {
    return RandomUserRegisteredEmbeddable(
        age = age,
        date = date
    )
}

fun RandomUserRegisteredEmbeddable.toDomain(): RandomUserRegistered {
    return RandomUserRegistered(
        age = age,
        date = date
    )
}