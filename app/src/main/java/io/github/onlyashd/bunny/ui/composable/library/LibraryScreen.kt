package io.github.onlyashd.bunny.ui.composable.library

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import io.github.onlyashd.bunny.R
import io.github.onlyashd.bunny.util.composable.SetupTopBar
import io.github.onlyashd.bunny.util.extensions.getString

@Composable
fun LibraryScreen(navController: NavHostController) {
    SetupTopBar(visible = false)
}