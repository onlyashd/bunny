package io.github.onlyashd.bunny.api

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.os.RemoteException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * A generic, reactive wrapper for Android Bound Services using AIDL.
 * It converts the asynchronous callback-based ServiceConnection into a modern Kotlin StateFlow.
 *
 * **Example usage:**
 * ```kt
 * // Use this in a ViewModel or Repository
 * provider.bind()
 *
 * // Observe the connection status
 * provider.state.collect { service ->
 *     if (service != null) {
 *         // Service is ready to use
 *         service.doSomething()
 *     }
 * }
 * ```
 *
 *  ### IMPORTANT!
 *  1. Always ensure that unbind() is called in the appropriate lifecycle method
 *  (e.g., onCleared() in a ViewModel or onStop() in an Activity)
 *  to prevent memory leaks.
 *  2. Every call to a method inside IConfiguration can throw a [RemoteException]
 *  if the remote process crashes. Always use try-catch blocks for production code.
 *
 * @param T The AIDL interface type (e.g., IConfiguration).
 * @property state A StateFlow<T?> that emits the service interface when connected and null when disconnected.
 * @property bind Initiates the connection to the remote service.
 * @property unbind Safely disconnects and clears the state.
 */
class ServiceProvider<T>(
    private val context: Context,
    private val action: String,
    private val packageName: String,
    private val converter: (IBinder) -> T
) {
    private val _state = MutableStateFlow<T?>(null)
    val state = _state.asStateFlow()

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
            _state.value = binder?.let { converter(it) }
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            _state.value = null
        }
    }

    fun bind() {
        val intent = Intent(action).apply { setPackage(packageName) }
        context.bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    fun unbind() {
        context.unbindService(connection)
        _state.value = null
    }
}