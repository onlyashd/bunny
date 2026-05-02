package io.github.onlyashd.bunny.ui.composable.reader

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import io.github.onlyashd.bunny.books.BooksViewModel

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun EpubReaderWebView(
    booksViewModel: BooksViewModel = hiltViewModel()
) {
    val data = booksViewModel.bookItem.collectAsState().value

    AndroidView(factory = { context ->
        WebView(context).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()

            loadDataWithBaseURL(
                "file:///android_asset/",
                data.uri,
                "application/xhtml+xml",
                "UTF-8",
                null
            )
        }
    })
}
