package com.gyvacha.shift_test.data.remote.dto

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class RandomUserLocationDto(
    val city: String,
    val coordinates: RandomUserCoordinatesDto,
    val country: String,
    @Serializable(with = PostcodeSerializer::class)
    val postcode: String,
    val state: String,
    val street: RandomUserStreetDto,
    val timezone: RandomUserTimezoneDto
)

object PostcodeSerializer : KSerializer<String> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Postcode", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): String {
        return try {
            decoder.decodeString()
        } catch (_: Exception) {
            decoder.decodeInt().toString()
        }
    }

    override fun serialize(encoder: Encoder, value: String) {
        encoder.encodeString(value)
    }
}