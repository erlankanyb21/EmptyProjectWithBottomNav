package com.example.myapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val selectedIcon: ImageVector? = null,
    val unselectedIcon: ImageVector? = null,
    val label: String
) {
    object Main : Screen(
        route = "main",
        label = "Main"
    )

    object Home : Screen(
        route = "home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        label = "Home"
    )

    object Notifications : Screen(
        route = "notifications",
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Outlined.Notifications,
        label = "Notifications"
    )

    object Profile : Screen(
        route = "profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        label = "Profile"
    )

    object Stats : Screen(
        route = "stats",
        label = "stats"
    )


    object Anim : Screen(
        route = "anim",
        label = "anim"
    )

    object Exoplayer : Screen(
        route = "exoplayer",
        label = "exoplayer"
    )

    object PushNotification : Screen(
        route = "PushNotification",
        label = "PushNotification"
    )

    object Web : Screen(
        route = "Web",
        label = "Web"
    )

    object DragAndDrop : Screen(
        route = "dragAndDrop",
        label = "dragAndDrop"
    )

    object Gallery : Screen(
        route = "gallery",
        label = "gallery"
    )

    object Swipe : Screen(
        route = "swipe",
        label = "swipe"
    )
}
