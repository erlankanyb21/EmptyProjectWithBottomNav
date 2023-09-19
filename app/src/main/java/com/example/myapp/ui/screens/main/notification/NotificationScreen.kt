package com.example.myapp.ui.screens.main.notification

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun NotificationScreen(
    navController: NavController
) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Push notification")
        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Web view")
        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Animations")
        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Exo player")
        }
    }
}