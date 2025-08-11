package com.example.instagramprofile_jetpackcompose.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    name: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.Black,
            modifier = modifier.padding(end = 20.dp)
        )

        Text(
            text = name,
            fontSize = 20.sp,
            color = Color.Black,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = modifier.weight(1f).padding(end = 12.dp)
        )

        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = null,
            tint = Color.Black,
            modifier = modifier.padding(end = 12.dp)
        )

        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = null,
            tint = Color.Black,
        )
    }
}
