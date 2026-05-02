package io.github.onlyashd.bunny.ui.composable.books

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
import coil3.compose.AsyncImage
import io.github.onlyashd.bunny.core.model.BookData
import io.github.onlyashd.bunny.util.composable.colorScheme
import io.github.onlyashd.bunny.util.composable.typography

@Composable
fun Book(
    book: BookData,
    onClick: () -> Unit,
) {
    ConstraintLayout(
        modifier = Modifier
            .height(250.dp)
            .width(250.dp)
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
            book.coverImg.let {
                if (it.isEmpty()) {
                    DefaultBookCover()
                } else {
                    AsyncImage(
                        model = it.toByteArray(),
                        contentDescription = null
                    )
                }
            }
        }

        LinearProgressIndicator(
            progress = { book.progress },
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