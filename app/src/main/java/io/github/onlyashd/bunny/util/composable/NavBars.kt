package io.github.onlyashd.bunny.util.composable

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import io.github.onlyashd.bunny.core.MainViewModel

@Composable
fun SetupTopBar(
    title: String = "",
    visible: Boolean = true,
    backBtnVisible: Boolean = true,
    viewModel: MainViewModel = hiltViewModel()
) {
    viewModel.setTopBarTitle(title)
    viewModel.setTopBarVisibility(visible)
    viewModel.setTopBarBackBtnVisibility(backBtnVisible)
}

@Composable
fun SetupBottomBar(
    visible: Boolean = true,
    viewModel: MainViewModel = hiltViewModel()
) {
    viewModel.setBottomBarVisibility(visible)
}