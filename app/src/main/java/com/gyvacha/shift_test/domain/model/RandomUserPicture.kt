package com.gyvacha.shift_test.domain.model

import com.gyvacha.shift_test.data.local.entities.RandomUserPictureEmbeddable
import com.gyvacha.shift_test.data.remote.dto.RandomUserPictureDto

data class RandomUserPicture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

fun RandomUserPicture.toDto(): RandomUserPictureDto {
    return RandomUserPictureDto(
        large = large,
        medium = medium,
        thumbnail = thumbnail
    )
}

fun RandomUserPictureDto.toDomain(): RandomUserPicture {
    return RandomUserPicture(
        large = large,
        medium = medium,
        thumbnail = thumbnail
    )
}

fun RandomUserPictureDto.toEmbeddable(): RandomUserPictureEmbeddable {
    return RandomUserPictureEmbeddable(
        large = large,
        medium = medium,
        thumbnail = thumbnail
    )
}

fun RandomUserPictureEmbeddable.toDomain(): RandomUserPicture {
    return RandomUserPicture(
        large = large,
        medium = medium,
        thumbnail = thumbnail
    )
}