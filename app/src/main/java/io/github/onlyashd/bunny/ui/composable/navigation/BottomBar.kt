package io.github.onlyashd.bunny.ui.composable.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import io.github.onlyashd.bunny.R
import io.github.onlyashd.bunny.core.MainViewModel
import io.github.onlyashd.bunny.core.Screen
import io.github.onlyashd.bunny.util.extensions.getDrawable

@Composable
fun BottomBar(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val navigate: (String, Int) -> Unit = { route, selected ->
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        selectedItem = selected
    }

    AnimatedVisibility(mainViewModel.bottomBarVisibility.collectAsState().value) {
        NavigationBar {
            NavigationBarItem(
                icon = { Icon(R.drawable.home_filled.getDrawable(), "") },
                selected = selectedItem == 0,
                onClick = { navigate(Screen.Home.route, 0) }
            )

            NavigationBarItem(
                icon = { Icon(R.drawable.settings_filled.getDrawable(), "") },
                selected = selectedItem == 1,
                onClick = { navigate(Screen.Settings.route, 1) }
            )
        }
    }
}