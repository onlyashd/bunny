package io.github.onlyashd.bunny.core.model

import nl.siegmann.epublib.domain.Book

/**
 * All items, except [genre], [progress], [lastOpened] and [collection] exist inside [Book],
 * we just extract them for easy access in the composables.
 */
data class BookData(
    val isbn: String = "",
    val uri: String = "",
    val coverImg: String = "",
    val title: String? = "",
    val author: String = "",
    val genre: String = "",
    val language: String = "",
    val progress: Float = 0F,
    val lastOpened: String? = null,
    val collection: String? = null,
)
