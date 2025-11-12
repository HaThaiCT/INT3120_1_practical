package com.example.bookshelf.network

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.QueryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * API service interface for interacting with the Google Books API.
 */
interface BookshelfApiService {

    companion object {
        const val BASE_URL = "https://www.googleapis.com/books/v1/"
    }

    /**
     * Searches for books based on a query string.
     *
     * @param query The search query.
     * @return A Response containing the QueryResponse with list of books.
     */
    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String): Response<QueryResponse>

    /**
     * Retrieves details of a specific book by its ID.
     *
     * @param id The book ID.
     * @return A Response containing the Book details.
     */
    @GET("volumes/{id}")
    suspend fun getBook(@Path("id") id: String): Response<Book>
}