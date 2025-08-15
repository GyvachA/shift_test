package com.gyvacha.shift_test.domain.model

import com.gyvacha.shift_test.data.local.entities.RandomUserDobEmbeddable
import com.gyvacha.shift_test.data.remote.dto.RandomUserDobDto

data class RandomUserDob(
    val age: Int,
    val date: String
)

fun RandomUserDob.toDto(): RandomUserDobDto {
    return RandomUserDobDto(
        age = age,
        date = date
    )
}

fun RandomUserDobDto.toDomain(): RandomUserDob {
    return RandomUserDob(
        age = age,
        date = date
    )
}

fun RandomUserDobDto.toEmbeddable(): RandomUserDobEmbeddable {
    return RandomUserDobEmbeddable(
        age = age,
        date = date
    )
}

fun RandomUserDobEmbeddable.toDomain(): RandomUserDob {
    return RandomUserDob(
        age = age,
        date = date
    )
}