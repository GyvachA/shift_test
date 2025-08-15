package com.gyvacha.shift_test.domain.model

import com.gyvacha.shift_test.data.local.entities.RandomUserNameEmbeddable
import com.gyvacha.shift_test.data.remote.dto.RandomUserNameDto

data class RandomUserName(
    val first: String,
    val last: String,
    val title: String
) {
    fun getFullName(): String {
        return "$title $first $last"
    }
}

fun RandomUserName.toDto(): RandomUserNameDto {
    return RandomUserNameDto(
        first = first,
        last = last,
        title = title
    )
}

fun RandomUserNameDto.toDomain(): RandomUserName {
    return RandomUserName(
        first = first,
        last = last,
        title = title
    )
}

fun RandomUserNameDto.toEmbeddable(): RandomUserNameEmbeddable {
    return RandomUserNameEmbeddable(
        first = first,
        last = last,
        title = title
    )
}

fun RandomUserNameEmbeddable.toDomain(): RandomUserName {
    return RandomUserName(
        first = first,
        last = last,
        title = title
    )
}