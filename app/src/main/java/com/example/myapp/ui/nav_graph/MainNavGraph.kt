package com.example.myapp.ui.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapp.ui.Screen
import com.example.myapp.ui.screens.main.MainScreen
import com.example.myapp.ui.screens.main.home.HomeScreen
import com.example.myapp.ui.screens.main.notification.AnimationScreen
import com.example.myapp.ui.screens.main.notification.ExoPlayerScreen
import com.example.myapp.ui.screens.main.notification.NotificationScreen
import com.example.myapp.ui.screens.main.notification.PushNotificationScreen
import com.example.myapp.ui.screens.main.notification.WebScreen
import com.example.myapp.ui.screens.main.profile.DragAndDropScreen
import com.example.myapp.ui.screens.main.profile.GalleryScreen
import com.example.myapp.ui.screens.main.profile.ProfileScreen
import com.example.myapp.ui.screens.main.profile.StatsScreen
import com.example.myapp.ui.screens.main.profile.SwipeToDismissScreen

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


        composable(route = Screen.Anim.route) {
            AnimationScreen(navController = navController)
        }

        composable(route = Screen.Exoplayer.route) {
            ExoPlayerScreen(navController = navController)
        }
        composable(route = Screen.PushNotification.route) {
            PushNotificationScreen(navController = navController)
        }
        composable(route = Screen.Web.route) {
            WebScreen(navController = navController)
        }

        composable(route = Screen.DragAndDrop.route) {
            DragAndDropScreen(navController = navController)
        }

        composable(route = Screen.Gallery.route) {
            GalleryScreen(navController = navController)
        }

        composable(route = Screen.Swipe.route) {
            SwipeToDismissScreen(navController = navController)
        }

//        detailsNavGraph(navController = navController)
    }
}