package io.github.onlyashd.bunnyservice.core

import android.content.Intent
import android.os.IBinder
import io.github.onlyashd.shared.Actions
import io.github.onlyashd.bunnyservice.stubs.ConfigurationImpl
import javax.inject.Inject

class Binder @Inject constructor(
    private val configImpl: ConfigurationImpl,
) {
    fun bind(intent: Intent): IBinder? {
        return when (intent.action) {
            Actions.CONFIGURATION -> configImpl
            else -> null
        }
    }
}
