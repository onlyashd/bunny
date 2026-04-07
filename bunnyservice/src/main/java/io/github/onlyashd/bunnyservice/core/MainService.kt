package io.github.onlyashd.bunnyservice.core

import android.app.Service
import android.content.Intent
import android.os.IBinder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainService: Service() {
    @Inject
    lateinit var binderCoordinator: Binder

    override fun onBind(intent: Intent): IBinder? {
        return binderCoordinator.bind(intent)
    }
}