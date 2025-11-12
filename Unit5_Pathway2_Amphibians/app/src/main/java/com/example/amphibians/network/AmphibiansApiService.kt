package com.example.amphibians.network

import com.example.amphibians.model.Amphibian
import retrofit2.http.GET

/**
 * API service interface for fetching amphibians data.
 */
interface AmphibiansApiService {
    /**
     * Fetches the list of amphibians from the API.
     *
     * @return A list of [Amphibian] objects.
     */
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}
