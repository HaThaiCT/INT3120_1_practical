package com.example.unit5_pathway1_coroutines

import kotlinx.coroutines.*

/**
 * Demonstrates exception handling and cancellation in coroutines.
 * Shows how exceptions in async tasks are propagated and handled.
 */
fun main() {
    runBlocking {
        println("Weather forecast")
        try {
            println(getWeatherReport())
        } catch (e: AssertionError) {
            println("Caught exception in runBlocking(): $e")
            println("Report unavailable at this time")
        }
        println("Have a good day!")
    }
}

/**
 * Fetches weather report asynchronously, but may throw exception if temperature fetching fails.
 *
 * @return A string combining forecast and temperature.
 * @throws AssertionError if temperature is invalid.
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
 * Simulates fetching temperature, but throws an exception to demonstrate error handling.
 *
 * @return The temperature string (never reached due to exception).
 * @throws AssertionError Always thrown to simulate invalid temperature.
 */
suspend fun getTemperature(): String {
    delay(500)
    throw AssertionError("Temperature is invalid")
    return "30\u00b0C"
}
