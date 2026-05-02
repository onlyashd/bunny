package io.github.onlyashd.bunny.observability

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.onlyashd.bunny.BuildConfig
import io.github.onlyashd.bunny.core.MainEvent
import io.github.onlyashd.bunny.core.MainViewModel
import io.github.onlyashd.bunny.core.db.AppPreferences
import io.sentry.android.core.SentryAndroid
import javax.inject.Inject

@HiltViewModel
class SentryViewModel @Inject constructor(
    context: Context,
    private val viewModel: MainViewModel
): ViewModel() {
    init {
        SentryAndroid.init(context) { options ->
            options.isEnabled = viewModel.stateApp.sentryState
            options.isDebug = BuildConfig.DEBUG
            options.dsn = BuildConfig.SENTRY_DSN
            options.release = BuildConfig.VERSION_NAME
            options.environment = BuildConfig.BUILD_TYPE
            options.isAttachThreads = true
            // Options that include personal info are always disabled.
            // To know more, visit https://docs.sentry.io/platforms/android/configuration/options/
            options.isEnableAppLifecycleBreadcrumbs = false
            options.isEnableSystemEventBreadcrumbs = false
            options.isEnableAppComponentBreadcrumbs = false
            options.isEnableUserInteractionBreadcrumbs = false
            options.isCollectAdditionalContext = false
            options.isEnableAutoSessionTracking = false
            options.isSendClientReports = false
        }
    }

    fun toggleSentry() {
        AppPreferences.Sentry.toggleState()
        viewModel.onEvent(MainEvent.SentryStateChange())
    }

    fun toggleSentryScreening() {
        AppPreferences.Sentry.toggleScreening()
        viewModel.onEvent(MainEvent.SentryScreeningChange())
    }
}