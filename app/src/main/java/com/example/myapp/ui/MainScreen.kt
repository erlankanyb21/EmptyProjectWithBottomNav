package com.example.myapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapp.ui.nav_graph.SetupNavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val screens = listOf(
        Screen.Home,
        Screen.Collections,
        Screen.Profile
    )

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    val showBottomBar = navController
        .currentBackStackEntryAsState().value?.destination?.route in screens.map { it.route }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    screens.forEachIndexed { index, screen ->
                        NavigationBarItem(
                            icon = {
                                (if (index == selectedItemIndex) {
                                    screen.selectedIcon
                                } else screen.unselectedIcon)?.let {
                                    Icon(
                                        imageVector = it,
                                        contentDescription = screen.label
                                    )
                                }
                            },
                            label = { Text(screen.label) },
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            SetupNavGraph(navController = navController)
        }
    }
}
