package com.example.myapp.feature.weather_screen.data

import com.example.myapp.feature.weather_screen.data.api.model.WeatherModel
import com.example.myapp.feature.weather_screen.domain.model.WeatherDomainModel

fun WeatherModel.toDomain() : WeatherDomainModel {
    return WeatherDomainModel(
        this.weatherMainModel.temp
    )
}