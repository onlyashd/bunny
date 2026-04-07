package io.github.onlyashd.bunny.core

import io.github.onlyashd.bunny.ui.theme.Theme

sealed class MainEvent {
    data class ThemeChange(val theme: Theme): MainEvent()
    data class ToolbarChange(val toolbarTitle: String): MainEvent()
}