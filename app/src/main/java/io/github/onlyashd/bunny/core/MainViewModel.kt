package io.github.onlyashd.bunny.core

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    var stateApp by mutableStateOf(MainState())

    fun onEvent(event: MainEvent) {
        stateApp = when (event) {
            is MainEvent.ThemeChange -> {
                stateApp.copy(theme = event.theme)
            }

            is MainEvent.ToolbarChange -> {
                stateApp.copy(toolbarTitle = event.toolbarTitle)
            }
        }
    }
}