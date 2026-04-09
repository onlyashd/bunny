package io.github.onlyashd.bunny.ui.composable.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import io.github.onlyashd.bunny.R
import io.github.onlyashd.bunny.core.MainViewModel
import io.github.onlyashd.bunny.observability.SentryViewModel
import io.github.onlyashd.bunny.ui.composable.settings.SentryDetailsDialog
import io.github.onlyashd.bunny.util.composable.SetupTopBar
import io.github.onlyashd.bunny.util.extensions.getString

@Composable
fun HomeScreen(
    navController: NavHostController,
    sentryViewModel: SentryViewModel = hiltViewModel(),
    mainViewModel: MainViewModel = hiltViewModel()
) {
    var sentryDialogVisible by remember { mutableStateOf(true) }

    SetupTopBar(R.string.app_name.getString(), backBtnVisible = false)

    if (mainViewModel.stateApp.enabledSentryScreening && sentryDialogVisible) {
        SentryDetailsDialog(
            showOnHide = true,
            onClick = {
                sentryViewModel.toggleSentry()
                sentryViewModel.toggleSentryScreening()
            },
            onDismiss = { sentryDialogVisible = !sentryDialogVisible },
            onHide = { sentryViewModel.toggleSentryScreening() }
        )
    }
}