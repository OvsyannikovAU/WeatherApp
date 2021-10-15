package com.example.myapp.feature.weather_screen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.feature.weather_screen.domain.WeatherInterrupter
import com.example.myapp.feature.weather_screen.domain.model.WeatherDomainModel
import kotlinx.coroutines.launch

class WeatherScreenViewModel(private val interrupter: WeatherInterrupter) : ViewModel() {
    val livedata : MutableLiveData<WeatherDomainModel> = MutableLiveData()

    fun requestWeather() {
        viewModelScope.launch {
            livedata.postValue( interrupter.getWeather() )
        }
    }
}