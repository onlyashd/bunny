package io.github.onlyashd.bunny.core

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    var stateApp by mutableStateOf(MainState())
    private val _topBarTitle = MutableStateFlow("")
    val topBarTitle = _topBarTitle.asStateFlow()
    private val _topBarVisibility = MutableStateFlow(true)
    val topBarVisibility = _topBarVisibility.asStateFlow()
    private val _bottomBarVisibility = MutableStateFlow(true)
    val bottomBarVisibility = _bottomBarVisibility.asStateFlow()

    fun onEvent(event: MainEvent) {
        val eventTag = "MainEvent"
        stateApp = when (event) {
            is MainEvent.ThemeChange -> {
                Log.i(eventTag, "Theme changed to ${event.theme}")
                stateApp.copy(theme = event.theme)
            }

            is MainEvent.SentryStateChange -> {
                Log.i(eventTag, "Sentry state changed to ${!stateApp.sentryState}")
                stateApp.copy(sentryState = !stateApp.sentryState)
            }

            is MainEvent.SentryScreeningChange -> {
                Log.i(eventTag, "Sentry screening change to ${!stateApp.enabledSentryScreening}")
                stateApp.copy(enabledSentryScreening = !stateApp.enabledSentryScreening)
            }
        }
    }

    fun setTopBarTitle(title: String) {
        _topBarTitle.value = title
    }

    fun setTopBarVisibility(visible: Boolean? = null) {
        _topBarVisibility.value = visible ?: !topBarVisibility.value
    }

    fun setBottomBarVisibility(visible: Boolean? = null) {
        _bottomBarVisibility.value = visible ?: !bottomBarVisibility.value
    }
}
