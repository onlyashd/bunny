package io.github.onlyashd.bunny.ui.composable.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import io.github.onlyashd.bunny.core.MainViewModel
import io.github.onlyashd.bunny.util.composable.colorScheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    AnimatedVisibility(visible = mainViewModel.topBarVisibility.collectAsState().value) {
        CenterAlignedTopAppBar(
            title = { Text(mainViewModel.topBarTitle.collectAsState().value) },
            expandedHeight = 90.dp,
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
            modifier = Modifier,
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorScheme().primary,
                scrolledContainerColor = colorScheme().primary,
                navigationIconContentColor = colorScheme().onPrimary,
                titleContentColor = colorScheme().onPrimary,
                actionIconContentColor = colorScheme().onPrimary,
                subtitleContentColor = colorScheme().onPrimary
            )
        )
    }
}
