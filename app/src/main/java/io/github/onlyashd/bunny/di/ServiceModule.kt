package io.github.onlyashd.bunny.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.onlyashd.shared.Actions
import io.github.onlyashd.shared.Constants
import io.github.onlyashd.shared.IConfiguration
import io.github.onlyashd.bunny.api.Configuration
import io.github.onlyashd.bunny.api.ServiceProvider
import javax.inject.Singleton

/**
 * Configures Hilt to provide specific instances of ServiceProvider.
 * By using the @[Configuration] qualifier, you allow the app to inject multiple
 * different AIDL providers without type conflicts.
 *
 * **Example injection:**
 * ```kt
 * class MyRepository @Inject constructor(
 *     @Configuration private val configProvider: ServiceProvider<IConfiguration>
 * ) { ... }
 * ```
 */
@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    @Configuration
    fun provideConfigurationProvider(@ApplicationContext context: Context): ServiceProvider<IConfiguration> {
        return ServiceProvider(
            context = context,
            action = Actions.CONFIGURATION,
            packageName = Constants.PKG_SERVICE,
            converter = { IConfiguration.Stub.asInterface(it) }
        )
    }
}
