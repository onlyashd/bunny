package io.github.onlyashd.bunny.ui.composable.reader

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import io.github.onlyashd.bunny.R
import io.github.onlyashd.bunny.util.composable.SetupToolbar
import io.github.onlyashd.bunny.util.extensions.getString

@Composable
fun ReaderScreen(navController: NavHostController) {
    SetupToolbar(R.string.reader.getString()) // todo = set the book name
}