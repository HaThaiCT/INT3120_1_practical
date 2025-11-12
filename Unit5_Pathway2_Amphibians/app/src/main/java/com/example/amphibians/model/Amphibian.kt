package com.example.amphibians.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing an amphibian.
 *
 * @property name The name of the amphibian.
 * @property type The type of the amphibian (e.g., "Toad").
 * @property description A description of the amphibian.
 * @property imgSrc The URL of the amphibian's image.
 */
@Serializable
data class Amphibian(
    val name: String,
    val type: String,
    val description: String,
    @SerialName("img_src") val imgSrc: String
)
