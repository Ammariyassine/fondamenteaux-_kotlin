package com.example.fescity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fescity.ui.theme.FesCityTheme
import com.example.fescity.R // Import R file for drawable resources

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FesCityTheme {
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
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.fes), // Reference to the "fes" image
            contentDescription = "Background image of Fes",
            modifier = Modifier.fillMaxSize(), // Fills the entire screen
            contentScale = ContentScale.Crop // Adjusts the scaling to fill the background
        )

        // Foreground content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // lkhli3 image
            Image(
                painter = painterResource(id = R.drawable.images_khli3), // lkhli3 image in drawable folder
                contentDescription = "Image of lkhli3",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp), // Adjust the height as needed
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
    FesCityTheme {
        MainContent()
    }
}
