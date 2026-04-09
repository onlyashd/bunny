package io.github.onlyashd.bunny.core

import io.github.onlyashd.bunny.ui.theme.Theme

data class MainState(
    val theme: Theme = AppPreferences.getTheme(),
    val sentryState: Boolean = AppPreferences.getSentryState(),
    val enabledSentryScreening: Boolean = AppPreferences.getSentryScreening(),
)
