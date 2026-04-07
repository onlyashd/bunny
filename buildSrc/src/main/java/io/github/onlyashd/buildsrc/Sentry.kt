package io.github.onlyashd.buildsrc

import java.io.File
import java.util.Properties

object Sentry {
    val APP_DNS by lazy { getSentryConfig("SENTRY_APP_DNS") }
    val APP_TOKEN by lazy { getSentryConfig("SENTRY_APP_TOKEN") }
    val SERVICE_DNS by lazy { getSentryConfig("SENTRY_SERVICE_DNS") }
    val SERVICE_TOKEN by lazy { getSentryConfig("SENTRY_SERVICE_TOKEN") }

    private fun getSentryConfig(param: String): String {
        val properties = Properties()
        val propFile = File("sentry.properties")

        return if (propFile.exists()) {
            propFile.inputStream().use { properties.load(it) }
            properties.getProperty(param) ?: ""
        } else {
            // Fallback to Environment Variables (CI/CD)
            System.getenv(param) ?: ""
        }
    }
}