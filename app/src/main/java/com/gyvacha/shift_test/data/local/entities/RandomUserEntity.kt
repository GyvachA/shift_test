package com.gyvacha.shift_test.data.local.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "random_users")
data class RandomUserEntity(
    @PrimaryKey val uuid: String,
    val gender: String,
    @Embedded(prefix = "name_") val name: RandomUserNameEmbeddable,
    @Embedded(prefix = "id_") val id: RandomUserIdEmbeddable,
    @Embedded(prefix = "location_") val location: RandomUserLocationEmbeddable,
    val email: String,
    @Embedded(prefix = "login_") val login: RandomUserLoginEmbeddable,
    @Embedded(prefix = "dob_") val dob: RandomUserDobEmbeddable,
    @Embedded(prefix = "registered_") val registered: RandomUserRegisteredEmbeddable,
    val phone: String,
    val cell: String,
    @Embedded(prefix = "picture_") val picture: RandomUserPictureEmbeddable,
    val nat: String
)

data class RandomUserNameEmbeddable(
    val title: String,
    val first: String,
    val last: String
)

data class RandomUserLocationEmbeddable(
    @Embedded(prefix = "street_") val street: RandomUserStreetEmbeddable,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    @Embedded(prefix = "coordinates_") val coordinates: RandomUserCoordinatesEmbeddable,
    @Embedded(prefix = "timezone_") val timezone: RandomUserTimezoneEmbeddable
)

data class RandomUserStreetEmbeddable(
    val number: Int,
    val name: String
)

data class RandomUserCoordinatesEmbeddable(
    val latitude: String,
    val longitude: String
)

data class RandomUserTimezoneEmbeddable(
    val offset: String,
    val description: String
)

data class RandomUserLoginEmbeddable(
    val username: String,
    val password: String,
    val salt: String,
    val md5: String,
    val sha1: String,
    val sha256: String,
    val uuid: String
)

data class RandomUserDobEmbeddable(
    val date: String,
    val age: Int
)

data class RandomUserRegisteredEmbeddable(
    val date: String,
    val age: Int
)

data class RandomUserPictureEmbeddable(
    val large: String,
    val medium: String,
    val thumbnail: String
)

data class RandomUserIdEmbeddable(
    val name: String,
    val value: String
)