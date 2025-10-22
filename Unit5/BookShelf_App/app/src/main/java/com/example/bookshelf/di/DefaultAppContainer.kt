package com.example.bookshelf.di

import com.example.bookshelf.data.BookshelfRepository
import com.example.bookshelf.data.DefaultBookshelfRepository
import com.example.bookshelf.network.BookshelfApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create

/**
 * Default implementation of the app container.
 */
class DefaultAppContainer : AppContainer {

    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    override val bookshelfApiService: BookshelfApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BookshelfApiService.BASE_URL)
            .build()
            .create()
    }

    override val bookshelfRepository: BookshelfRepository by lazy {
        DefaultBookshelfRepository(bookshelfApiService)
    }
}