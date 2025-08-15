package com.gyvacha.shift_test.domain.model

import com.gyvacha.shift_test.data.local.entities.RandomUserStreetEmbeddable
import com.gyvacha.shift_test.data.remote.dto.RandomUserStreetDto

data class RandomUserStreet(
    val name: String,
    val number: Int
)

fun RandomUserStreet.toDto(): RandomUserStreetDto {
    return RandomUserStreetDto(
        name = name,
        number = number
    )
}

fun RandomUserStreetDto.toDomain(): RandomUserStreet {
    return RandomUserStreet(
        name = name,
        number = number
    )
}

fun RandomUserStreetDto.toEmbeddable(): RandomUserStreetEmbeddable {
    return RandomUserStreetEmbeddable(
        name = name,
        number = number
    )
}

fun RandomUserStreetEmbeddable.toDomain(): RandomUserStreet {
    return RandomUserStreet(
        name = name,
        number = number
    )
}