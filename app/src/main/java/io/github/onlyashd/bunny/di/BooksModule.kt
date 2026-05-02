package io.github.onlyashd.bunny.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.onlyashd.bunny.books.BooksViewModel
import io.github.onlyashd.bunny.core.db.BookStorage
import nl.siegmann.epublib.epub.EpubReader
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BooksModule {
    @Provides
    @Singleton
    fun provideLibraryViewModel(): BooksViewModel =
        BooksViewModel(EpubReader(), BookStorage)
}
