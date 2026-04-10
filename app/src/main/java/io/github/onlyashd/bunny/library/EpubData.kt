package io.github.onlyashd.bunny.library

data class EpubData(
    val id: String,
    val title: String,
    val author: String,
    val language: String,
    val fileUriString: String,
    val coverImageUri: String? = null,
    val readingProgress: Float? = null,
)