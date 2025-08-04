package com.example.instagramprofile_jetpackcompose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramprofile_jetpackcompose.R


@Composable
fun ProfileSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        ProfileImageAndStatSection()

        Spacer(modifier = Modifier.height(16.dp))

        ProfileDescription(
            displayName = "4p.exe",
            description = "almost 2 years of coding experience\n" +
                    "Want me to make your app, send me your email!\n" +
                    "Subscribe to my youtube channel",
            url = "https://www.youtube.com/@Ap20yrso",
            followedBy = listOf("chelseafc", "leomessi"),
            otherCount = 15,
        )
    }
}
@Composable
fun ProfileImageAndStatSection(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxWidth()
    ) {

        ProfileRoundedImage(
            image = painterResource(id = R.drawable.agpyae),
            modifier = Modifier
                .size(100.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))
        ProfileStat(
            numberText = "100",
            text = "Posts"
        )

        ProfileStat(
            numberText = "12.5k",
            text = "Followers"
        )

        ProfileStat(
            numberText = "78",
            text = "Following"
        )
    }
}

@Composable
fun ProfileRoundedImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ProfileStat(
    numberText: String,
    text: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        val letterSpacing = 1.sp
        val lineHeight = 20.sp

        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            fontSize = 12.sp
        )

        Text(
            text = url,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            fontSize = 12.sp,
            color = Color(0xFF3D3D91)
        )

        Text(
            text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
                append("Followed by ")

                followedBy.forEachIndexed { index, name ->
                    pushStyle(boldStyle)
                    append(name)
                    pop()

                    if(index < followedBy.size -1 ){
                        append(", ")
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))

                if(otherCount > 2) {
                    append(" and ")
                    pushStyle(boldStyle)
                    append("$otherCount others")
                }
            },
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            fontSize = 12.sp
        )
    }
}