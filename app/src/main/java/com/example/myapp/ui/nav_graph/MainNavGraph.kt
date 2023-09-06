package com.example.myapp.ui.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapp.ui.Screen
import com.example.myapp.ui.screens.main.MainScreen
import com.example.myapp.ui.screens.main.home.HomeScreen
import com.example.myapp.ui.screens.main.notification.NotificationScreen
import com.example.myapp.ui.screens.main.profile.StatsScreen
import com.example.myapp.ui.screens.main.profile.ProfileScreen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Main.route) {
            MainScreen()
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = Screen.Notifications.route) {
            NotificationScreen(navController = navController)
        }
        composable(route = Screen.Stats.route) {
            StatsScreen(navController = navController)
        }
//        detailsNavGraph(navController = navController)
    }
}