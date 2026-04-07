package io.github.onlyashd.bunny.core

import io.github.onlyashd.bunny.ui.theme.Theme
import io.paperdb.Paper

object AppPreferences {
    const val APP_THEME = "AppTheme"
    const val TOOLBAR_TITLE = "ToolbarTitle"

    fun setTheme(theme: Theme) {
        Paper.book().write(APP_THEME, theme)
    }

    fun getTheme(): Theme {
        return Paper.book().read(APP_THEME, Theme.Aqua)!!
    }

    fun setToolbar(title: String) {
        Paper.book().write(TOOLBAR_TITLE, title)
    }

    fun getToolbar(): String {
        return Paper.book().read(TOOLBAR_TITLE, "")!!
    }
}