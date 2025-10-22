package com.example.bookshelf.model

import kotlinx.serialization.Serializable

/**
 * Data class representing a book from the Google Books API.
 *
 * @property id The unique identifier of the book.
 * @property description A description of the book.
 * @property volumeInfo Information about the book's volume.
 * @property saleInfo Sales information for the book.
 */
@Serializable
data class Book(
    val id: String,
    val description: String,
    val volumeInfo: VolumeInfo,
    val saleInfo: SaleInfo
) {
    /**
     * Returns the formatted price of the book.
     *
     * @return The price as a string, or empty if not available.
     */
    fun getPrice(): String {
        return saleInfo.listPrice?.let { "${it.amount} ${it.currency}" } ?: ""
    }
}

/**
 * Data class representing volume information of a book.
 *
 * @property title The title of the book.
 * @property subtitle The subtitle of the book.
 * @property description A description of the book.
 * @property imageLinks Links to book images.
 * @property authors List of authors.
 * @property publisher The publisher.
 * @property publishedDate The publication date.
 */
@Serializable
data class VolumeInfo(
    val title: String,
    val subtitle: String,
    val description: String,
    val imageLinks: ImageLinks? = null,
    val authors: List<String>,
    val publisher: String,
    val publishedDate: String,
) {
    /**
     * Returns all authors as a comma-separated string.
     *
     * @return The authors string.
     */
    fun allAuthors(): String = authors.joinToString(", ")
}

/**
 * Data class representing image links for a book.
 *
 * @property smallThumbnail URL for small thumbnail.
 * @property thumbnail URL for thumbnail.
 */
@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String,
) {
    /**
     * Returns the HTTPS version of the thumbnail URL.
     */
    val httpsThumbnail: String
        get() = thumbnail.replace("http", "https")
}

/**
 * Data class representing sales information for a book.
 *
 * @property country The country code.
 * @property isEbook Whether the book is an ebook.
 * @property listPrice The list price information.
 */
@Serializable
data class SaleInfo(
    val country: String,
    val isEbook: Boolean,
    val listPrice: ListPrice?
) {
    /**
     * Returns the formatted price or "N/A" if not available.
     */
    val formattedPrice: String
        get() = listPrice?.let { "${it.amount ?: "N/A"} ${it.currency ?: "N/A"}" } ?: "N/A"
}

/**
 * Data class representing the list price of a book.
 *
 * @property amount The price amount.
 * @property currency The currency code.
 */
@Serializable
data class ListPrice(
    val amount: Float?,
    val currency: String? = ""
)