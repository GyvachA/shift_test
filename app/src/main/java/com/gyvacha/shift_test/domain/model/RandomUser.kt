package com.gyvacha.shift_test.domain.model

import com.gyvacha.shift_test.data.local.entities.RandomUserEntity
import com.gyvacha.shift_test.data.remote.dto.RandomUserDto

data class RandomUser(
    val cell: String,
    val dob: RandomUserDob,
    val email: String,
    val gender: String,
    val id: RandomUserId,
    val location: RandomUserLocation,
    val login: RandomUserLogin,
    val name: RandomUserName,
    val nat: String,
    val phone: String,
    val picture: RandomUserPicture,
    val registered: RandomUserRegistered
)

fun RandomUser.toDto(): RandomUserDto {
    return RandomUserDto(
        cell = cell,
        dob = dob.toDto(),
        email = email,
        gender = gender,
        id = id.toDto(),
        location = location.toDto(),
        login = login.toDto(),
        name = name.toDto(),
        nat = nat,
        phone = phone,
        picture = picture.toDto(),
        registered = registered.toDto()
    )
}

fun RandomUserDto.toDomain(): RandomUser {
    return RandomUser(
        cell = cell,
        dob = dob.toDomain(),
        email = email,
        gender = gender,
        id = id.toDomain(),
        location = location.toDomain(),
        login = login.toDomain(),
        name = name.toDomain(),
        nat = nat,
        phone = phone,
        picture = picture.toDomain(),
        registered = registered.toDomain()
    )
}

fun RandomUserDto.toEntity(): RandomUserEntity {
    return RandomUserEntity(
        cell = cell,
        dob = dob.toEmbeddable(),
        email = email,
        gender = gender,
        id = id.toEmbeddable(),
        location = location.toEmbeddable(),
        login = login.toEmbeddable(),
        name = name.toEmbeddable(),
        nat = nat,
        phone = phone,
        picture = picture.toEmbeddable(),
        registered = registered.toEmbeddable(),
        uuid = login.uuid
    )
}

fun RandomUserEntity.toDomain(): RandomUser {
    return RandomUser(
        cell = cell,
        dob = dob.toDomain(),
        email = email,
        gender = gender,
        id = id.toDomain(),
        location = location.toDomain(),
        login = login.toDomain(),
        name = name.toDomain(),
        nat = nat,
        phone = phone,
        picture = picture.toDomain(),
        registered = registered.toDomain()
    )
}