package io.github.onlyashd.bunnyservice.stubs

import android.os.Bundle
import io.github.onlyashd.aidl.IConfiguration
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Implementation of the IConfiguration AIDL interface.
 * We use @Inject so Hilt can provide this to the Binder coordinator.
 */
@Singleton
class ConfigurationImpl @Inject constructor() : IConfiguration.Stub() {
    override fun getConfig(data: Bundle): Bundle {
        val response = Bundle()
        response.putString("status", "success")

        return response
    }
}
