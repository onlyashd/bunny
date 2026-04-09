package io.github.onlyashd.buildsrc

import java.io.File
import java.util.Properties

object Sentry {
    const val ORG = "bunny-app"
    val AUTH_TOKEN by lazy { getSentryConfig("SENTRY_AUTH_TOKEN") }
    val APP_DSN by lazy { getSentryConfig("SENTRY_APP_DSN") }
    val SERVICE_DSN by lazy { getSentryConfig("SENTRY_SERVICE_DSN") }

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