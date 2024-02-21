package com.maschago.multiplatformui

import android.app.Application
import di.initKoin

class MultiplatformUiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}