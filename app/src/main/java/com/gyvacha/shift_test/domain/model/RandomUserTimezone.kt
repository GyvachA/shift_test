package com.gyvacha.shift_test.domain.model

import com.gyvacha.shift_test.data.local.entities.RandomUserTimezoneEmbeddable
import com.gyvacha.shift_test.data.remote.dto.RandomUserTimezoneDto

data class RandomUserTimezone(
    val description: String,
    val offset: String
) {
    fun getTimezone(): String {
        return "$offset ($description)"
    }
}

fun RandomUserTimezone.toDto(): RandomUserTimezoneDto {
    return RandomUserTimezoneDto(
        description = description,
        offset = offset
    )
}

fun RandomUserTimezoneDto.toDomain(): RandomUserTimezone {
    return RandomUserTimezone(
        description = description,
        offset = offset
    )
}

fun RandomUserTimezoneDto.toEmbeddable(): RandomUserTimezoneEmbeddable {
    return RandomUserTimezoneEmbeddable(
        description = description,
        offset = offset
    )
}

fun RandomUserTimezoneEmbeddable.toDomain(): RandomUserTimezone {
    return RandomUserTimezone(
        description = description,
        offset = offset
    )
}