package io.github.onlyashd.bunny.core

import io.github.onlyashd.bunny.ui.theme.Theme
import io.paperdb.Paper

object AppPreferences {
    const val APP_THEME = "AppTheme"
    const val SENTRY_STATE = "SentryState"
    const val SENTRY_SCREENING = "SentryScreening"

    fun setTheme(theme: Theme) {
        Paper.book().write(APP_THEME, theme)
    }

    fun getTheme(): Theme {
        return Paper.book().read(APP_THEME, Theme.Aqua)!!
    }

    fun toggleSentryState() {
        val current = Paper.book().read(SENTRY_STATE, false)!!
        Paper.book().write(SENTRY_STATE, !current)
    }

    fun getSentryState(): Boolean {
        return Paper.book().read(SENTRY_STATE, false)!!
    }

    fun toggleSentryScreening() {
        val current = Paper.book().read(SENTRY_SCREENING, true)!!
        Paper.book().write(SENTRY_SCREENING, !current)
    }

    fun getSentryScreening(): Boolean {
        return Paper.book().read(SENTRY_SCREENING, true)!!
    }
}