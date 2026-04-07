package io.github.onlyashd.bunny.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.onlyashd.bunny.core.MainViewModel
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {
    @Provides
    @Singleton
    fun provideMainViewModel(): MainViewModel = MainViewModel()
}