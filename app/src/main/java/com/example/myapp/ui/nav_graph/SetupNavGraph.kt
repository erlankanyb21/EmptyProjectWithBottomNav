package com.example.myapp.ui.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapp.ui.Screen
import com.example.myapp.ui.screens.home.HomeScreen
import com.example.myapp.ui.screens.notification.NotificationScreen
import com.example.myapp.ui.screens.profile.ProfileScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Collections.route) { NotificationScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
    }
}