package io.github.onlyashd.bunny.books

import android.content.Context
import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.onlyashd.bunny.core.db.BookStorage
import io.github.onlyashd.bunny.core.model.BookData
import io.github.onlyashd.bunny.util.extensions.addNotNull
import io.github.onlyashd.bunny.util.extensions.toKey
import io.github.vinceglb.filekit.PlatformFile
import io.github.vinceglb.filekit.nameWithoutExtension
import io.github.vinceglb.filekit.path
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import nl.siegmann.epublib.domain.Identifier
import nl.siegmann.epublib.epub.EpubReader
import java.util.zip.ZipInputStream
import javax.inject.Inject


@HiltViewModel
class BooksViewModel @Inject constructor(
    private val epubReader: EpubReader,
    private val bookStorage: BookStorage,
) : ViewModel() {
    private val _bookList = MutableStateFlow<List<BookData>>(emptyList())
    val bookList: StateFlow<List<BookData>> = _bookList.asStateFlow()

    private val _bookItem = MutableStateFlow(BookData())
    val bookItem = _bookItem.asStateFlow()

    fun loadBookList() {
        viewModelScope.launch(Dispatchers.IO) {
            _bookList.value = bookStorage.get()
        }
    }

    fun openBook(bookData: BookData) {
        viewModelScope.launch(Dispatchers.IO) {
            _bookItem.value = bookData
        }
    }

    fun saveBooks(files: List<PlatformFile>?, context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            val bookList = mutableListOf<BookData>()
            files?.forEach { file ->
                val uri = file.path.toUri()
                val inputStream = context.contentResolver.openInputStream(uri)
                val book = epubReader.readEpub(ZipInputStream(inputStream))
                val bookData = BookData(
                    isbn = book.metadata.identifiers.find { it.scheme == Identifier.Scheme.ISBN }?.value
                        ?: file.nameWithoutExtension.toKey(),
                    uri = file.path,
                    progress = 0F,
                    coverImg = book.coverImage.data.toString(),
                    title = book.title,
                    author = book.metadata.authors.toString(),
                    genre = book.metadata.subjects.toString(),
                    lastOpened = null,
                    collection = null,
                    language = book.metadata.language,
                )
                inputStream?.close()
                Log.d("SavedBook", bookData.toString())
                bookList.addNotNull(bookData)
            }
            bookStorage.set(bookList)
        }
    }

    fun updateBook(book: BookData) {
        viewModelScope.launch(Dispatchers.IO) {
            bookStorage.set(book)
        }
    }
}