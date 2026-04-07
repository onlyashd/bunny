package io.github.onlyashd.bunny.ui.composable

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import io.github.onlyashd.bunny.R
import io.github.onlyashd.bunny.util.composable.colorScheme
import io.github.onlyashd.bunny.util.extensions.getDrawable
import io.github.onlyashd.bunny.util.extensions.getString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String, navController: NavHostController) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(
                onClick = { navController.popBackStack() },
            ) {
                Icon(R.drawable.arrow_back.getDrawable(), R.string.back.getString())
            }
        },
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
