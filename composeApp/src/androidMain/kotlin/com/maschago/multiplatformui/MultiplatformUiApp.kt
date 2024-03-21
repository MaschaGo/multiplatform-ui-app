package com.maschago.multiplatformui

import android.app.Application
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

class MultiplatformUiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize Logging.
        Napier.base(DebugAntilog())
    }
}