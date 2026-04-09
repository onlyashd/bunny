package io.github.onlyashd.bunny.ui.composable.rsvp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import io.github.onlyashd.bunny.R
import io.github.onlyashd.bunny.util.composable.SetupTopBar
import io.github.onlyashd.bunny.util.extensions.getString

@Composable
fun RsvpScreen(navController: NavHostController) {
    SetupTopBar(R.string.reader.getString()) // todo = set the book name
}