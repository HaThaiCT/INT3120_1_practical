package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibiansApiService

/**
 * Repository interface for amphibians data.
 */
interface AmphibiansRepository {
    /**
     * Retrieves the list of amphibians.
     *
     * @return A list of [Amphibian] objects.
     */
    suspend fun getAmphibians(): List<Amphibian>
}

/**
 * Default implementation of the amphibians repository.
 *
 * @param amphibiansApiService The API service for fetching data.
 */
class DefaultAmphibiansRepository(
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> = amphibiansApiService.getAmphibians()
}
