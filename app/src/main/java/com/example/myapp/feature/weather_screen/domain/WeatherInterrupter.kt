package com.example.myapp.feature.weather_screen.domain

import com.example.myapp.feature.weather_screen.data.api.WeatherRepo
import com.example.myapp.feature.weather_screen.domain.model.WeatherDomainModel

class WeatherInterrupter(private val repo: WeatherRepo) {
    suspend fun getWeather(): WeatherDomainModel{
        return repo.getWeather()
    }
}