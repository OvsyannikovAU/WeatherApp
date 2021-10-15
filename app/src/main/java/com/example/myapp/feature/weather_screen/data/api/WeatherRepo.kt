package com.example.myapp.feature.weather_screen.data.api

import com.example.myapp.feature.weather_screen.domain.model.WeatherDomainModel

interface WeatherRepo {
    suspend fun getWeather() : WeatherDomainModel
}