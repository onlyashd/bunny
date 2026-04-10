package io.github.onlyashd.bunny.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.onlyashd.bunny.library.LibraryViewModel
import nl.siegmann.epublib.epub.EpubReader
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LibraryModule {
    @Provides
    @Singleton
    fun providesLibraryViewModel(): LibraryViewModel = LibraryViewModel(EpubReader())
}