package io.github.onlyashd.bunny.ui.composable.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import io.github.onlyashd.bunny.R
import io.github.onlyashd.bunny.util.composable.SetupToolbar
import io.github.onlyashd.bunny.util.extensions.getString

@Composable
fun HomeScreen(navController: NavHostController) {
    SetupToolbar(R.string.app_name.getString())
}