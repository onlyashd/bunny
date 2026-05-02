package io.github.onlyashd.bunny.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import io.github.onlyashd.bunny.core.MainEvent
import io.github.onlyashd.bunny.core.MainViewModel
import io.github.onlyashd.bunny.core.db.AppPreferences
import io.github.onlyashd.bunny.ui.theme.themes.AquaTheme
import io.github.onlyashd.bunny.ui.theme.themes.BrownTheme
import io.github.onlyashd.bunny.ui.theme.themes.EarthyTheme
import io.github.onlyashd.bunny.ui.theme.themes.GreenTheme
import io.github.onlyashd.bunny.ui.theme.themes.PinkTheme
import io.github.onlyashd.bunny.ui.theme.themes.PurpleTheme
import io.github.onlyashd.bunny.ui.theme.themes.YellowTheme

@Composable
fun AppTheme(
    theme: Theme,
    darkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkMode) {
        when (theme) {
            Theme.Aqua -> AquaTheme.darkScheme
            Theme.Brown -> BrownTheme.darkScheme
            Theme.Earthy -> EarthyTheme.darkScheme
            Theme.Green -> GreenTheme.darkScheme
            Theme.Pink -> PinkTheme.darkScheme
            Theme.Purple -> PurpleTheme.darkScheme
            Theme.Yellow -> YellowTheme.darkScheme
        }
    } else {
        when (theme) {
            Theme.Aqua -> AquaTheme.lightScheme
            Theme.Brown -> BrownTheme.lightScheme
            Theme.Earthy -> EarthyTheme.lightScheme
            Theme.Green -> GreenTheme.lightScheme
            Theme.Pink -> PinkTheme.lightScheme
            Theme.Purple -> PurpleTheme.lightScheme
            Theme.Yellow -> YellowTheme.lightScheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

fun setAquaTheme(viewModel: MainViewModel) {
    setTheme(Theme.Aqua, viewModel)
}

fun setBrownTheme(viewModel: MainViewModel) {
    setTheme(Theme.Brown, viewModel)
}

fun setEarthyTheme(viewModel: MainViewModel) {
    setTheme(Theme.Earthy, viewModel)
}

fun setGreenTheme(viewModel: MainViewModel) {
    setTheme(Theme.Green, viewModel)
}

fun setPinkTheme(viewModel: MainViewModel) {
    setTheme(Theme.Pink, viewModel)
}

fun setPurpleTheme(viewModel: MainViewModel) {
   setTheme(Theme.Purple, viewModel)
}

fun setYellowTheme(viewModel: MainViewModel) {
    setTheme(Theme.Yellow, viewModel)
}

private fun setTheme(theme: Theme, viewModel: MainViewModel) {
    AppPreferences.UI.setTheme(theme)
    viewModel.onEvent(MainEvent.ThemeChange(theme))
}