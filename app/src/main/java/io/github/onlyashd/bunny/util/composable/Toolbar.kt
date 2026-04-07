package io.github.onlyashd.bunny.util.composable

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import io.github.onlyashd.bunny.core.AppPreferences
import io.github.onlyashd.bunny.core.MainEvent
import io.github.onlyashd.bunny.core.MainViewModel

@Composable
fun SetupToolbar(
    title: String,
    viewModel: MainViewModel = hiltViewModel()
) {
    AppPreferences.setToolbar(title)
    viewModel.onEvent(MainEvent.ToolbarChange(title))
}