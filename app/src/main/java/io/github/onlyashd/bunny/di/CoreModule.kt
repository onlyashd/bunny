package io.github.onlyashd.bunny.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.onlyashd.bunny.core.MainViewModel
import io.github.onlyashd.bunny.observability.SentryViewModel
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {
    @Provides
    @Singleton
    fun provideMainViewModel(): MainViewModel = MainViewModel()

    @Provides
    @Singleton
    fun providesSentryViewModel(
        @ApplicationContext context: Context,
        mainViewModel: MainViewModel
    ): SentryViewModel = SentryViewModel(context, mainViewModel)
}