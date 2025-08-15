package com.gyvacha.shift_test.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import com.gyvacha.shift_test.R
import com.gyvacha.shift_test.domain.model.RandomUser

@Composable
fun ProfileCard(
    randomUser: RandomUser,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    BaseCard(
        modifier = modifier,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.medium_padding)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfilePhoto(
                photoUrl = randomUser.picture.thumbnail,
                modifier = Modifier.size(dimensionResource(R.dimen.small_photo_size))
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier.weight(1f)
                    .padding(horizontal = dimensionResource(R.dimen.medium_padding))
            ) {
                Text(
                    text = randomUser.name.getFullName(),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = randomUser.location.getAddress(),
                    style = MaterialTheme.typography.labelSmall
                )
                Text(
                    text = randomUser.phone,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}