package io.github.onlyashd.bunny.ui.composable.settings

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import io.github.onlyashd.bunny.R
import io.github.onlyashd.bunny.util.composable.SetupToolbar
import io.github.onlyashd.bunny.util.extensions.getString

@Composable
fun SettingsScreen(navController: NavHostController) {
    SetupToolbar(R.string.settings.getString())

    ThemePicker()
}