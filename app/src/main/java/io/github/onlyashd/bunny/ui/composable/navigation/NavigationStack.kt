package io.github.onlyashd.bunny.ui.composable.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.github.onlyashd.bunny.core.Screen
import io.github.onlyashd.bunny.ui.composable.downloader.DownloaderScreen
import io.github.onlyashd.bunny.ui.composable.home.HomeScreen
import io.github.onlyashd.bunny.ui.composable.library.LibraryScreen
import io.github.onlyashd.bunny.ui.composable.reader.ReaderScreen
import io.github.onlyashd.bunny.ui.composable.rsvp.RsvpScreen
import io.github.onlyashd.bunny.ui.composable.settings.SettingsScreen

@Composable
fun NavigationStack(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Reader.route) { ReaderScreen(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
        composable(Screen.Rsvp.route) { RsvpScreen(navController) }
        composable(Screen.Library.route) { LibraryScreen(navController) }
        composable(Screen.Downloader.route) { DownloaderScreen(navController) }
    }
}
