package io.github.onlyashd.bunny.core.db

import io.github.onlyashd.bunny.ui.theme.Theme
import io.paperdb.Paper

object AppPreferences {
    object UI {
        private const val APP_THEME = "app_theme"

        fun setTheme(theme: Theme) {
            Paper.book().write(APP_THEME, theme)
        }

        fun getTheme(): Theme {
            return Paper.book().read(APP_THEME, Theme.Green)!!
        }
    }

    object Sentry {
        private const val SENTRY_STATE = "sentry_state"
        private const val SENTRY_SCREENING = "sentry_screening"

        fun toggleState() {
            val current = Paper.book().read(SENTRY_STATE, false)!!
            Paper.book().write(SENTRY_STATE, !current)
        }

        fun getState(): Boolean {
            return Paper.book().read(SENTRY_STATE, false)!!
        }

        fun toggleScreening() {
            val current = Paper.book().read(SENTRY_SCREENING, true)!!
            Paper.book().write(SENTRY_SCREENING, !current)
        }

        fun getScreening(): Boolean {
            return Paper.book().read(SENTRY_SCREENING, true)!!
        }
    }
}