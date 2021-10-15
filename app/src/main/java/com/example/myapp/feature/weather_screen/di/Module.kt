package com.example.myapp.feature.weather_screen.di

import com.example.myapp.feature.weather_screen.data.api.WeatherApi
import com.example.myapp.feature.weather_screen.data.api.WeatherRemoteSource
import com.example.myapp.feature.weather_screen.data.api.WeatherRepo
import com.example.myapp.feature.weather_screen.data.api.WeatherRepoImpl
import com.example.myapp.feature.weather_screen.domain.WeatherInterrupter
import com.example.myapp.feature.weather_screen.ui.WeatherScreenViewModel
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.openweathermap.org/"
val appModule = module {
    single {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<WeatherApi> {
        get<Retrofit>().create(WeatherApi::class.java)
    }

    single<WeatherRemoteSource> {
        WeatherRemoteSource( get<WeatherApi>() )
    }

    single<WeatherRepo>{
        WeatherRepoImpl( get<WeatherRemoteSource>() )
    }

    single<WeatherInterrupter>{
        WeatherInterrupter( get<WeatherRepo>() )
    }

    viewModel<WeatherScreenViewModel> {
        WeatherScreenViewModel( get<WeatherInterrupter>() )
    }
}