package com.gyvacha.shift_test.domain.model

import com.gyvacha.shift_test.data.local.entities.RandomUserIdEmbeddable
import com.gyvacha.shift_test.data.remote.dto.RandomUserIdDto

data class RandomUserId(
    val name: String,
    val value: String
) {
    fun getDocument(): String {
        return "$name${if (value.isEmpty()) "" else " $value"}"
    }
}

fun RandomUserId.toDto(): RandomUserIdDto {
    return RandomUserIdDto(
        name = name,
        value = value
    )
}

fun RandomUserIdDto.toDomain(): RandomUserId {
    return RandomUserId(
        name = name,
        value = value
    )
}

fun RandomUserIdDto.toEmbeddable(): RandomUserIdEmbeddable {
    return RandomUserIdEmbeddable(
        name = name,
        value = value
    )
}

fun RandomUserIdEmbeddable.toDomain(): RandomUserId {
    return RandomUserId(
        name = name,
        value = value
    )
}