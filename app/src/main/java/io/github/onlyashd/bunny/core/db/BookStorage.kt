package io.github.onlyashd.bunny.core.db

import io.github.onlyashd.bunny.core.model.BookData
import io.github.onlyashd.bunny.util.extensions.addNotNull
import io.paperdb.Paper

object BookStorage {
    private val db = Paper.book("books")
    private fun getAllKeys(): List<String> = db.allKeys

    /**
     * Heavy operation, make sure to only call on background threads.
     */
    fun get(): List<BookData> {
        val keys = getAllKeys()

        val list = mutableListOf<BookData>()
        keys.forEach { key ->
            list.addNotNull(get(key))
        }
        return list
    }

    fun get(key: String): BookData? {
        return db.read(key)
    }

    /**
     * Heavy operation, make sure to only call on background threads.
     */
    fun set(books: List<BookData>) {
        books.forEach { book ->
            db.write<BookData>(book.isbn, book)
        }
    }

    fun set(book: BookData) {
        db.write<BookData>(book.isbn, book)
    }

}
