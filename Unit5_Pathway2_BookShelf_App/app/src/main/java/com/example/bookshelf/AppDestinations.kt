package com.example.bookshelf

/**
 * Enum class representing the different destinations in the app navigation.
 *
 * @property title The display title for each destination.
 */
enum class AppDestinations(val title: String) {
    MenuScreen(title = "Menu"),
    QueryScreen(title = "Google Bookshelf"),
    FavoriteScreen(title = "My Favorite Books"),
    DetailScreen(title = "Book: ")
}