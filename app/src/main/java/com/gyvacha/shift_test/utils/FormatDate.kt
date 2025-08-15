package com.gyvacha.shift_test.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun formatDate(isoDate: String?): String {
    if (isoDate == null) return "00.00.0000"
    val dateTime = LocalDateTime.parse(isoDate, DateTimeFormatter.ISO_DATE_TIME)
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    return dateTime.format(formatter)
}
