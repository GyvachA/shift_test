package com.gyvacha.shift_test.domain.model

import com.gyvacha.shift_test.data.local.entities.RandomUserCoordinatesEmbeddable
import com.gyvacha.shift_test.data.remote.dto.RandomUserCoordinatesDto

data class RandomUserCoordinates(
    val latitude: String,
    val longitude: String
) {
    fun getCoordinates(): String {
        return "$latitude, $longitude"
    }
}

fun RandomUserCoordinates.toDto(): RandomUserCoordinatesDto {
    return RandomUserCoordinatesDto(
        latitude = latitude,
        longitude = longitude
    )
}

fun RandomUserCoordinatesDto.toDomain(): RandomUserCoordinates {
    return RandomUserCoordinates(
        latitude = latitude,
        longitude = longitude
    )
}

fun RandomUserCoordinatesDto.toEmbeddable(): RandomUserCoordinatesEmbeddable {
    return RandomUserCoordinatesEmbeddable(
        latitude = latitude,
        longitude = longitude
    )
}

fun RandomUserCoordinatesEmbeddable.toDomain(): RandomUserCoordinates {
    return RandomUserCoordinates(
        latitude = latitude,
        longitude = longitude
    )
}