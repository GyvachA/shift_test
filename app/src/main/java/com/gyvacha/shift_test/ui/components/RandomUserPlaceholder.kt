package com.gyvacha.shift_test.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.gyvacha.shift_test.R

@Composable
fun RandomUserPlaceholder(modifier: Modifier = Modifier) {

    BaseCard(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.medium_padding)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.small_photo_size))
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onSurfaceVariant)
            )
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.medium_padding)))
            Column {
                Box(
                    modifier = Modifier
                        .height(dimensionResource(R.dimen.placeholder_title_height))
                        .fillMaxWidth(0.7f)
                        .background(MaterialTheme.colorScheme.onSurfaceVariant)
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.small_padding)))
                Box(
                    modifier = Modifier
                        .height(dimensionResource(R.dimen.placeholder_label_height))
                        .fillMaxWidth(0.5f)
                        .background(MaterialTheme.colorScheme.onSurfaceVariant)
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.small_padding)))
                Box(
                    modifier = Modifier
                        .height(dimensionResource(R.dimen.placeholder_label_height))
                        .fillMaxWidth(0.3f)
                        .background(MaterialTheme.colorScheme.onSurfaceVariant)
                )
            }
        }
    }
}

@Composable
@Preview
fun RandomUserPlaceholderPreview() {
    RandomUserPlaceholder()
}