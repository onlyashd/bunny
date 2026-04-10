package io.github.onlyashd.bunny.library

import android.content.Context
import androidx.core.net.toUri
import androidx.documentfile.provider.DocumentFile
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.paperdb.Paper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import nl.siegmann.epublib.domain.Book
import nl.siegmann.epublib.epub.EpubReader
import java.io.FileInputStream
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val epubReader: EpubReader
) : ViewModel() {
    private val _library = MutableStateFlow<List<EpubData>>(emptyList())
    val library: StateFlow<List<EpubData>> = _library

    val book = MutableStateFlow(Book())

    fun reloadFromCache() {
        val cached = Paper.book("library").read<List<EpubData>>("epubs", emptyList())!!
        _library.value = cached
    }

    fun loadLibraryFromFolder(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            val fetchedBooks = mutableListOf<EpubData>()
            val directory = DocumentFile.fromTreeUri(context, "file:///storage/emulated/0".toUri())

            directory?.listFiles()?.forEach { file ->
                val epub = file.name?.endsWith(".epub") == true
                val pdf = file.name?.endsWith(".pdf") == true
                if (epub || pdf) {
                    val book = epubReader.readEpub(FileInputStream(file.uri.path))
                    fetchedBooks.add(
                        EpubData(
                            id = book.metadata.identifiers.toString(),
                            title = book.title,
                            author = book.metadata.authors.toString(),
                            language = book.metadata.language,
                            fileUriString = file.uri.path!!,
                            coverImageUri = book.coverImage.href,
                        )
                    )
                }
            }

            Paper.book("library").write("epubs", fetchedBooks)
            _library.value = fetchedBooks
        }
    }

    fun loadBook(filePath: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                book.value = epubReader.readEpub(FileInputStream(filePath))
            }
        }
    }
}