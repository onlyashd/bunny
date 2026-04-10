package io.github.onlyashd.bunny.reader

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import io.github.onlyashd.bunny.library.LibraryViewModel

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun EpubReaderView(
    filePath: String,
    libraryViewModel: LibraryViewModel = hiltViewModel()
) {
    libraryViewModel.loadBook(filePath)
    val book = libraryViewModel.book.collectAsState().value
    val firstChapter = book.spine.getResource(0)
    val data = String(firstChapter.data)

    AndroidView(factory = { context ->
        WebView(context).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()

            loadDataWithBaseURL(
                "file:///android_asset/",
                data,
                "application/xhtml+xml",
                "UTF-8",
                null
            )
        }
    })
}
