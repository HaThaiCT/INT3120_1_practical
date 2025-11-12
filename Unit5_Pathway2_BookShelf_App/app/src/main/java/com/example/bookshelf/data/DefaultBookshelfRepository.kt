package com.example.bookshelf.data

import android.util.Log
import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BookshelfApiService

/**
 * Default Implementation of repository that retrieves volumes data from underlying data source.
 */
class DefaultBookshelfRepository(
    private val bookshelfApiService: BookshelfApiService
) : BookshelfRepository {

    private val tag = "BookshelfRepository"

    /** Retrieves list of Volumes from underlying data source */
    override suspend fun getBooks(query: String): List<Book>? {
        return try {
            val response = bookshelfApiService.getBooks(query)
            if (response.isSuccessful) {
                response.body()?.items ?: emptyList()
            } else {
                Log.e(tag, "Failed to fetch books: ${response.code()} ${response.message()}")
                emptyList()
            }
        } catch (e: Exception) {
            Log.e(tag, "Exception while fetching books", e)
            null
        }
    }

    override suspend fun getBook(id: String): Book? {
        return try {
            val response = bookshelfApiService.getBook(id)
            if (response.isSuccessful) {
                response.body()
            } else {
                Log.e(tag, "Failed to fetch book $id: ${response.code()} ${response.message()}")
                null
            }
        } catch (e: Exception) {
            Log.e(tag, "Exception while fetching book $id", e)
            null
        }
    }
}