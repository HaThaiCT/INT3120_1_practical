package com.example.unit5_pathway1_coroutines

import kotlinx.coroutines.*

/**
 * Demonstrates asynchronous execution using coroutines.
 * Launches forecast and temperature fetching concurrently and combines results.
 */
fun main() {
    runBlocking {
        println("Weather forecast")
        println(getWeatherReport())
        println("Have a good day!")
    }
}

/**
 * Fetches weather report asynchronously by launching concurrent tasks for forecast and temperature.
 *
 * @return A string combining forecast and temperature.
 */
suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }
    "${forecast.await()} ${temperature.await()}"
}

/**
 * Simulates fetching weather forecast with a delay.
 *
 * @return The forecast string.
 */
suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

/**
 * Simulates fetching temperature with a delay.
 *
 * @return The temperature string.
 */
suspend fun getTemperature(): String {
    delay(1000)
    return "30\u00b0C"
}
