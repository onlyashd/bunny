package io.github.onlyashd.bunny.ui.composable.library

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.net.toUri
import coil3.compose.AsyncImage
import io.github.onlyashd.bunny.library.EpubData
import io.github.onlyashd.bunny.util.composable.colorScheme
import io.github.onlyashd.bunny.util.composable.typography

@Composable
fun Book(
    book: EpubData,
    onClick: () -> Unit,
) {
    ConstraintLayout(
        modifier = Modifier
            .height(96.dp)
            .width(48.dp)
            .clickable(onClick = { onClick() })
    ) {
        val (coverRef, titleRef, progressRef) = createRefs()

        ElevatedCard(
            modifier = Modifier
                .height(64.dp)
                .constrainAs(coverRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            if (book.coverImage.isNullOrEmpty()) {
                DefaultBookCover()
            } else {
                AsyncImage(
                    model = book.coverImage.toUri(),
                    contentDescription = null
                )
            }
        }

        LinearProgressIndicator(
            progress = { book.readingProgress ?: 0F },
            modifier = Modifier
                .constrainAs(progressRef) {
                    top.linkTo(coverRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        )

        Text(
            text = "${book.title} - ${book.author}",
            color = colorScheme().onPrimaryContainer,
            style = typography().titleSmall,
            modifier = Modifier
                .constrainAs(titleRef) {
                    top.linkTo(progressRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        )
    }
}