package io.github.onlyashd.bunny.core

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    var stateApp by mutableStateOf(MainState())
    val topBarTitle = MutableStateFlow("")
    val topBarVisibility = MutableStateFlow(true)
    val topBarBackBtnVisibility = MutableStateFlow(true)
    val bottomBarVisibility = MutableStateFlow(true)

    fun onEvent(event: MainEvent) {
        val eventTag = "MainEvent"
        stateApp = when (event) {
            is MainEvent.ThemeChange -> {
                Log.i(eventTag, "ThemeChange")
                stateApp.copy(theme = event.theme)
            }

            is MainEvent.SentryStateChange -> {
                Log.i(eventTag, "SentryStateChange")
                stateApp.copy(sentryState = !stateApp.sentryState)
            }

            is MainEvent.SentryScreeningChange -> {
                Log.i(eventTag, "SentryScreeningChange")
                stateApp.copy(enabledSentryScreening = !stateApp.enabledSentryScreening)
            }
        }
    }

    fun setTopBarTitle(title: String) {
        topBarTitle.value = title
    }

    fun setTopBarVisibility(visible: Boolean? = null) {
        topBarVisibility.value = visible ?: !topBarVisibility.value
    }

    fun setTopBarBackBtnVisibility(visible: Boolean? = null) {
        topBarBackBtnVisibility.value = visible ?: !topBarBackBtnVisibility.value
    }

    fun setBottomBarVisibility(visible: Boolean? = null) {
        bottomBarVisibility.value = visible ?: !bottomBarVisibility.value
    }
}