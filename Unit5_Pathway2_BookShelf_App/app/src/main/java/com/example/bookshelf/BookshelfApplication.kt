package com.example.bookshelf

import android.app.Application
import android.util.Log
import com.example.bookshelf.di.AppContainer
import com.example.bookshelf.di.DefaultAppContainer

/**
 * Application class for the Bookshelf app.
 * Initializes the dependency injection container.
 */
class BookshelfApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer

    /**
     * Called when the application is starting. Sets up the app container.
     */
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "BookshelfApplication onCreate called")
        container = DefaultAppContainer()
        Log.d(TAG, "App container initialized")
    }

    companion object {
        private const val TAG = "BookshelfApplication"
    }
}