package io.github.onlyashd.bunny.core

import io.github.onlyashd.bunny.core.db.AppPreferences
import io.github.onlyashd.bunny.ui.theme.Theme

data class MainState(
    val theme: Theme = AppPreferences.UI.getTheme(),
    val sentryState: Boolean = AppPreferences.Sentry.getState(),
    val enabledSentryScreening: Boolean = AppPreferences.Sentry.getScreening(),
)