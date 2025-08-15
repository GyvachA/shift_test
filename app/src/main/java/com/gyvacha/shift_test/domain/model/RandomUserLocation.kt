package com.gyvacha.shift_test.domain.model

import com.gyvacha.shift_test.data.local.entities.RandomUserLocationEmbeddable
import com.gyvacha.shift_test.data.remote.dto.RandomUserLocationDto

data class RandomUserLocation(
    val city: String,
    val coordinates: RandomUserCoordinates,
    val country: String,
    val postcode: String,
    val state: String,
    val street: RandomUserStreet,
    val timezone: RandomUserTimezone
) {
    fun getAddress(): String {
        return "$country, $state, $city, ${street.name}, ${street.number}, $postcode"
    }
}

fun RandomUserLocation.toDto(): RandomUserLocationDto {
    return RandomUserLocationDto(
        city = city,
        coordinates = coordinates.toDto(),
        country = country,
        postcode = postcode,
        state = state,
        street = street.toDto(),
        timezone = timezone.toDto()
    )
}

fun RandomUserLocationDto.toDomain(): RandomUserLocation {
    return RandomUserLocation(
        city = city,
        coordinates = coordinates.toDomain(),
        country = country,
        postcode = postcode,
        state = state,
        street = street.toDomain(),
        timezone = timezone.toDomain()
    )
}

fun RandomUserLocationDto.toEmbeddable(): RandomUserLocationEmbeddable {
    return RandomUserLocationEmbeddable(
        city = city,
        coordinates = coordinates.toEmbeddable(),
        country = country,
        postcode = postcode,
        state = state,
        street = street.toEmbeddable(),
        timezone = timezone.toEmbeddable()
    )
}

fun RandomUserLocationEmbeddable.toDomain(): RandomUserLocation {
    return RandomUserLocation(
        city = city,
        coordinates = coordinates.toDomain(),
        country = country,
        postcode = postcode,
        state = state,
        street = street.toDomain(),
        timezone = timezone.toDomain()
    )
}