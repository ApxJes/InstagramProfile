package com.example.instagramprofile_jetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramprofile_jetpackcompose.component.ButtonSection
import com.example.instagramprofile_jetpackcompose.component.HighlightSection
import com.example.instagramprofile_jetpackcompose.component.ProfileSection
import com.example.instagramprofile_jetpackcompose.component.StoryHighlight
import com.example.instagramprofile_jetpackcompose.component.TopBarSection

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(16.dp)
    ) {
        TopBarSection(name = "Aung Pyae Kyaw")

        Spacer(modifier = Modifier.height(16.dp))
        ProfileSection()

        Spacer(modifier = Modifier.height(16.dp))
        ButtonSection()

        Spacer(modifier = Modifier.height(10.dp))
        HighlightSection(
            storyHighlight = listOf(
                StoryHighlight(
                    image = painterResource(id = R.drawable.youtube),
                    text = "YouTube"
                ),

                StoryHighlight(
                    image = painterResource(id = R.drawable.qa),
                    text = "Q&A"
                ),

                StoryHighlight(
                    image = painterResource(id = R.drawable.discord),
                    text = "Discord"
                ),

                StoryHighlight(
                    image = painterResource(id = R.drawable.telegram),
                    text = "Telegram"
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreviewScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopBarSection(name = "Aung Pyae Kyaw")

        Spacer(modifier = Modifier.height(16.dp))
        ProfileSection()

        Spacer(modifier = Modifier.height(16.dp))
        ButtonSection()

        Spacer(modifier = Modifier.height(10.dp))
        HighlightSection(
            storyHighlight = listOf(
                StoryHighlight(
                    image = painterResource(id = R.drawable.youtube),
                    text = "YouTube"
                ),

                StoryHighlight(
                    image = painterResource(id = R.drawable.qa),
                    text = "Q&A"
                ),

                StoryHighlight(
                    image = painterResource(id = R.drawable.discord),
                    text = "Discord"
                ),

                StoryHighlight(
                    image = painterResource(id = R.drawable.telegram),
                    text = "Telegram"
                )
            )
        )
    }
}
