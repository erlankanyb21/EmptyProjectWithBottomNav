package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import com.example.myapp.ui.screens.main.profile.VariantTwo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
//                SetupNavGraph(navController = rememberNavController())
                Motion()
            }
        }
    }

    @Composable
    private fun Motion() {
        var progress = remember {
            mutableFloatStateOf(0f)
        }
        VariantTwo(progress = progress.floatValue)

        Slider(value = progress.floatValue, onValueChange = {
            progress.floatValue = it
        })
    }
}