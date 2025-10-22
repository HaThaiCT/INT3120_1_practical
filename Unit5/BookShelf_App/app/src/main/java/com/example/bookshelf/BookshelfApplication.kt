package com.example.bookshelf

import android.app.Application
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
        container = DefaultAppContainer()
    }
}