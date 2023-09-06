package com.example.myapp.ui.screens.main.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myapp.MainViewModel
import com.example.myapp.ui.screens.main.profile.VariantTwo
import org.koin.androidx.compose.getViewModel


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainViewModel = getViewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

    }
}