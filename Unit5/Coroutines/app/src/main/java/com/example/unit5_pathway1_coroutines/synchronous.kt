package com.example.unit5_pathway1_coroutines

import kotlin.system.*
import kotlinx.coroutines.*

/**
 * Demonstrates synchronous execution of coroutines.
 * Measures execution time for sequential weather data fetching.
 */
fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            printForecast()
            printTemperature()
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

/**
 * Prints the weather forecast after a simulated delay.
 */
suspend fun printForecast() {
    delay(1000)
    println("Sunny")
}

/**
 * Prints the temperature after a simulated delay.
 */
suspend fun printTemperature() {
    delay(1000)
    println("30\u00b0C")
}

