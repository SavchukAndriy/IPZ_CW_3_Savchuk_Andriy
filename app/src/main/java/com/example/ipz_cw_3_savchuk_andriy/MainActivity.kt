package com.example.ipz_cw_3_savchuk_andriy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ipz_cw_3_savchuk_andriy.ui.theme.IPZ_CW_3_Savchuk_AndriyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CW_3_Savchuk_AndriyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardList()
                }
            }
        }
    }
}

data class DayItem(val day: Int, val title: String, val imageRes: Int, val caption: String)

@Composable
fun DayCard(dayItem: DayItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = dayItem.title, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = dayItem.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(shape = RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = dayItem.caption)
    }
}

@Composable
fun CardList() {
    val daysList = generateDaysList()
    LazyColumn {
        items(daysList) { dayItem ->
            DayCard(dayItem = dayItem)
        }
    }
}

@Composable
fun generateDaysList(): List<DayItem> {
    val dayResources = listOf(
        R.drawable.photo1, R.drawable.photo2, R.drawable.photo3,
        R.drawable.photo4, R.drawable.photo5,
    )

    val dayTitles = listOf(
        "Day 1",
        "Day 2",
        "Day 3",
        "Day 4",
        "Day 5",
    )

    val dayCaptions = listOf(
        "Canyon",
        "Desert mountains",
        "Lake",
        "Desert",
        "River"
    )

    return (1..5).mapIndexed { index, day ->
        DayItem(
            day = day,
            title = dayTitles[index % dayTitles.size],
            imageRes = dayResources[index % dayResources.size],
            caption = dayCaptions[index % dayCaptions.size]
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardList() {
    IPZ_CW_3_Savchuk_AndriyTheme {
        CardList()
    }
}