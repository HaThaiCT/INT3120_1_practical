package com.example.amphibians

import android.app.Application
import com.example.amphibians.data.AppContainer
import com.example.amphibians.data.DefaultAppContainer

/**
 * Application class for the Amphibians app.
 * Initializes the dependency injection container.
 */
class AmphibiansApplication : Application() {
    lateinit var container: AppContainer

    /**
     * Called when the application is starting. Sets up the app container.
     */
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
