package io.github.onlyashd.bunny.ui.composable.books

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import io.github.onlyashd.bunny.R
import io.github.onlyashd.bunny.books.BooksViewModel
import io.github.onlyashd.bunny.core.Screen
import io.github.onlyashd.bunny.util.composable.SetupTopBar
import io.github.onlyashd.bunny.util.extensions.getString

@Composable
fun BookshelfScreen(
    navController: NavHostController,
    booksViewModel: BooksViewModel = hiltViewModel(),
) {
    SetupTopBar(R.string.library.getString())

    booksViewModel.loadBookList()
    val books = booksViewModel.bookList.collectAsState().value

    LazyVerticalGrid(
        columns = GridCells.Adaptive(250.dp),
        contentPadding = PaddingValues(12.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(books) { book ->
            Book(book) {
                booksViewModel.openBook(book)
                navController.navigate(Screen.Reader.route)
            }
        }
    }
}