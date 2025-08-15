package com.gyvacha.shift_test.utils

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

fun openDialer(phoneNumber: String, context: Context) {
    val intent = Intent(Intent.ACTION_DIAL).apply {
        data = "tel:$phoneNumber".toUri()
    }
    context.startActivity(intent)
}

fun openMap(latitude: Double, longitude: Double, context: Context) {
    val uri = "geo:$latitude,$longitude".toUri()
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = uri
    }
    context.startActivity(intent)
}

fun openMail(email: String, context: Context) {
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = "mailto:$email".toUri()
    }
    context.startActivity(intent)
}