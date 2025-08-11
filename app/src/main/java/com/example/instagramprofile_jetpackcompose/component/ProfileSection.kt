package com.example.instagramprofile_jetpackcompose.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramprofile_jetpackcompose.R
import kotlinx.coroutines.launch

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundedImage(
                image = painterResource(R.drawable.agpyae),
                modifier = modifier
                    .size(100.dp)
                    .weight(3f)
            )

            ProfileStat(typeText = "Posts", numberText = "101", modifier = modifier.padding(end = 12.dp))
            ProfileStat(typeText = "Followers", numberText = "10.5k", modifier = modifier.padding(end = 12.dp))
            ProfileStat(typeText = "Following", numberText = "75")
        }

        Spacer(modifier = modifier.height(10.dp))
        DescriptionSection(
            userName = "@4p.exe",
            description = "Native Android Developer",
            url = "https://www.youtube.com/@Ap20yrso",
            followedBy = listOf("chelseaFc", "Leomessi", "IshowSpeed", "Google", "Lisa"),
            count = 17,
        )

        Spacer(modifier = modifier.height(15.dp))
        ButtonSection(modifier = modifier.padding(4.dp))

        Spacer(modifier = modifier.height(12.dp))
        HighlightSection(
            highlights = listOf(
                Highlights(
                    image = painterResource(R.drawable.youtube),
                    text = "YouTube"
                ),

                Highlights(
                    image = painterResource(R.drawable.telegram),
                    text = "Telegram"
                ),

                Highlights(
                    image = painterResource(R.drawable.discord),
                    text = "Discord"
                ),

                Highlights(
                    image = painterResource(R.drawable.qa),
                    text = "Q&A"
                )
            )
        )

        Spacer(modifier = modifier.height(10.dp))
        TabSection()
    }
}

@Composable
fun RoundedImage(
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
    modifier: Modifier = Modifier,
    typeText: String,
    numberText: String
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = modifier
        ) {
            Text(
                text = numberText,
                fontSize = 18.sp,
                color = Color.Black,
            )

            Text(
                text = typeText,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
            )
        }
    }
}

@Composable
fun DescriptionSection(
    userName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    count: Int,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
    ) {
        Text(
            text = userName,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = description,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color.DarkGray,
            maxLines = 3,
            minLines = 1,
            lineHeight = 20.sp
        )

        Text(
            text = url,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )

        if(followedBy.isNotEmpty()) {
            Text(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.DarkGray,
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if(index != followedBy.lastIndex) {
                            append(", ")
                        }
                    }

                    if (count > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$count others")
                    }
                },
                letterSpacing = 1.sp,
                lineHeight = 16.sp
            )
        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {

    val width = 95.dp
    val height = 30.dp

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ActionButton(
            text = "Following",
            imageVector = Icons.Default.KeyboardArrowDown,
            modifier = modifier
                .defaultMinSize(width)
                .height(height)
        )

        ActionButton(
            text = "Message",
            modifier = modifier
                .defaultMinSize(width)
                .height(height)
        )

        ActionButton(
            text = "Email",
            modifier = modifier
                .defaultMinSize(width)
                .height(height)
        )

        ActionButton(
            text = "",
            imageVector = Icons.Default.KeyboardArrowDown,
            modifier = modifier
                .defaultMinSize(width)
                .height(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    imageVector: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.5.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        text?.let { text ->
            Text(
                text = text,
                fontSize = 14.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Normal
            )

            imageVector?.let { imageVector ->
                Icon(
                    imageVector = imageVector,
                    contentDescription = null,
                    tint = Color.DarkGray
                )
            }
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<Highlights>
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                modifier = modifier.padding(horizontal = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RoundedImage(
                    image = highlights[it].image,
                    modifier = modifier.size(70.dp)
                )

                Text(
                    text = highlights[it].text,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.DarkGray
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabSection(
    modifier: Modifier = Modifier
) {
    val tabItems = listOf(
        TabItems("", ImageVector.vectorResource(id = R.drawable.ic_grid)),
        TabItems("", ImageVector.vectorResource(id = R.drawable.ic_igtv)),
        TabItems("", ImageVector.vectorResource(id = R.drawable.ic_reel))
    )

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { tabItems.size })
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = modifier.fillMaxWidth()
        ) {
            tabItems.forEachIndexed { index, items ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = items.icon,
                            contentDescription = null,
                            tint = if (pagerState.currentPage == index) Color.Black else Color.DarkGray,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when (page) {
                0 -> PostSection(
                    posts = listOf(
                        painterResource(R.drawable.kmm),
                        painterResource(R.drawable.bad_habits),
                        painterResource(R.drawable.multiple_languages),
                        painterResource(R.drawable.master_logical_thinking),
                        painterResource(R.drawable.intermediate_dev),
                        painterResource(R.drawable.intermediate_dev),
                    )
                )
                1 -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("IGTV")
                }
                2 -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Reels")
                }
            }
        }
    }
}

@Composable
fun PostSection(
    modifier: Modifier = Modifier,
    posts: List<Painter>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}
