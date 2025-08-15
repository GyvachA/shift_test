package com.gyvacha.shift_test.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileInfoText(
    title: String,
    info: String,
    modifier: Modifier = Modifier,
    iconButton: (@Composable () -> Unit)? = null,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = "$title: ",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = info,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
        if (iconButton != null) {
            iconButton()
        }
    }
}

@Composable
@Preview
private fun ProfileInfoTextPreview() {
    ProfileInfoText(
        title = "Phone",
        info = "88005553535"
    ) {
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = null
            )
        }
    }
}