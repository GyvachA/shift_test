package com.gyvacha.shift_test.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RandomUserDto(
    val cell: String,
    val dob: RandomUserDobDto,
    val email: String,
    val gender: String,
    val id: RandomUserIdDto,
    val location: RandomUserLocationDto,
    val login: RandomUserLoginDto,
    val name: RandomUserNameDto,
    val nat: String,
    val phone: String,
    val picture: RandomUserPictureDto,
    val registered: RandomUserRegisteredDto
)