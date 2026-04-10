package io.github.onlyashd.bunny.ui.composable.library

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.onlyashd.bunny.R
import io.github.onlyashd.bunny.util.composable.colorScheme
import io.github.onlyashd.bunny.util.extensions.getDrawable

@Preview
@Composable
fun DefaultBookCover() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme().surfaceContainer)
    ) {
        Icon(
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.Center),
            painter = R.drawable.image.getDrawable(),
            contentDescription = null,
            tint = colorScheme().onSecondaryContainer
        )
    }
}