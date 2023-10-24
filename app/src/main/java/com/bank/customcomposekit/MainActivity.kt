package com.bank.customcomposekit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bank.customcomposekit.ui.theme.CustomComposeKitTheme
import com.beka.customprogressbar.CustomProgressWithPercent
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomComposeKitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }

}

@Composable
fun MainScreen() {
    CustomComposeKitTheme {
        Box(modifier = Modifier.fillMaxSize()) {

            var curValue by remember { mutableStateOf(0) }

            LaunchedEffect(true) {
                while (curValue < 1000) {
                    curValue++
                    delay(10L)
                }
            }

            CustomProgressWithPercent(
                modifier = Modifier.align(Alignment.Center)
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}

const val TAG = "General Tag"




