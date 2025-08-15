package com.gyvacha.shift_test.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.gyvacha.shift_test.R

@Composable
fun ProfilePhoto(
    photoUrl: String,
    modifier: Modifier = Modifier,
) {
    val model = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(photoUrl)
            .crossfade(true)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .build()
    )

    Image(
        painter = model,
        contentDescription = stringResource(R.string.profile_photo),
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}