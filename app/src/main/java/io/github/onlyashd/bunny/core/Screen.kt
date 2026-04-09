package io.github.onlyashd.bunny.core

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Settings: Screen("settings")
    object Reader: Screen("reader")
    object Rsvp: Screen("rsvp")
    object Library: Screen("rsvp")
    object Downloader: Screen("downloader")
}
