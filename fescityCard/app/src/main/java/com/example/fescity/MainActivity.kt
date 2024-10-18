package com.example.fescityCard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fescity.ui.theme.FesCityCardTheme
import com.example.fescity.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FesCityCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    // List of images to cycle through
    val imageList = listOf(
        R.drawable.images_khli3,    // First image (lkhli3)
        R.drawable.images_khli4,    // Second image
        R.drawable.images_khli5,    // Third image
        R.drawable.images_khli6     // Fourth image
    )

    // Hold the index of the current image
    var currentIndex by remember { mutableStateOf(0) }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.fes), // Reference to the "fes" image
            contentDescription = "Background image of Fes",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Foreground content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image that changes on click
            Image(
                painter = painterResource(id = imageList[currentIndex]), // Current image
                contentDescription = "Image of lkhli3",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clickable {
                        // On click, change to the next image
                        currentIndex = (currentIndex + 1) % imageList.size
                    },
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp)) // Space between image and text

            // Description
            Text(
                color = Color.White,
                text = "Lkhli3 is a famous dish from Fes, known for its unique flavor and traditional preparation methods. It's an essential part of Fassi cuisine.",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    FesCityCardTheme {
        MainContent()
    }
}
