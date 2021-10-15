package com.example.myapp.feature.weather_screen.ui

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.myapp.R
import com.example.myapp.feature.weather_screen.domain.model.WeatherDomainModel
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherScreenActivity : AppCompatActivity() {
    val weatherScreenViewModel by viewModel<WeatherScreenViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        weatherScreenViewModel.livedata.observe(this, Observer (::render) )
        weatherScreenViewModel.requestWeather()

    }

    private fun render(state : WeatherDomainModel){
        findViewById<TextView>( R.id.tvTemperature).let { it.text=state.temperature }
    }
}