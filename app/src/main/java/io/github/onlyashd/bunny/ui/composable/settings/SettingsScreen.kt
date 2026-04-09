package io.github.onlyashd.bunny.ui.composable.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import io.github.onlyashd.bunny.R
import io.github.onlyashd.bunny.observability.SentryViewModel
import io.github.onlyashd.bunny.util.composable.SetupTopBar
import io.github.onlyashd.bunny.util.extensions.getString

@Composable
fun SettingsScreen(
    navController: NavHostController,
    sentryViewModel: SentryViewModel = hiltViewModel(),
) {
    var sentryDialogVisible by remember { mutableStateOf(false) }
    SetupTopBar(R.string.settings.getString())

    Column(Modifier.padding(4.dp)) {
        ThemePicker()

        SentryToggle({ sentryDialogVisible = true })
    }

    if (sentryDialogVisible) {
        SentryDetailsDialog(
            onClick = {
                sentryViewModel.toggleSentry()
                sentryViewModel.toggleSentryScreening()
            },
            onDismiss = { sentryDialogVisible = !sentryDialogVisible },
        )
    }
}