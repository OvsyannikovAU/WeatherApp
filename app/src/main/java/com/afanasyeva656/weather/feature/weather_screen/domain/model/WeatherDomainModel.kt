package com.afanasyeva656.weather.feature.weather_screen.domain.model

data class WeatherDomainModel(
    val temperature: Double,
    val minTemperature: Double,
    val maxTemperature: Double,
    val humidity: Int
    )