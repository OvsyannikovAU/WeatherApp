package com.afanasyeva656.weather.feature.weather_screen.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.afanasyeva656.weather.R
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import kotlinx.coroutines.coroutineScope
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherScreenActivity: AppCompatActivity() {
    val weatherScreenViewModel by viewModel<WeatherScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        weatherScreenViewModel.lifeData.observe(this, Observer(::render))
        weatherScreenViewModel.requestWeather()
        findViewById<Button>(R.id.buttonWind).setOnClickListener {  }
    }

    private fun render(state: WeatherDomainModel) {
        findViewById<TextView>(R.id.tvTempeture).let { it.text = "Temperature " + state.temperature }
        findViewById<TextView>(R.id.tvMinTemperature).let{ it.text = "Min temperature " + state.minTemperature }
        findViewById<TextView>(R.id.tvMaxTemperature).let{ it.text = "Max temperature " + state.maxTemperature }
        findViewById<TextView>(R.id.tvHumidity).let{ it.text = "Humidity "+ state.humidity }
    }
}