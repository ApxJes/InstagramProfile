package com.example.instagramprofile_jetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramprofile_jetpackcompose.component.ProfileSection
import com.example.instagramprofile_jetpackcompose.component.TopBar
import com.example.instagramprofile_jetpackcompose.ui.theme.InstagramProfile_JetpackComposeTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopBar(name = "Aung Pyae Kyaw")

        Spacer(modifier = modifier.height(12.dp))
        ProfileSection()

    }
}

@Composable
@Preview(showBackground = true)
fun PreviewProfileScreen() {
    InstagramProfile_JetpackComposeTheme {
        ProfileScreen()
    }
}