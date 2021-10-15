package com.afanasyeva656.weather.feature.weather_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class WindModel(
    @SerializedName("speed")
    val speed : Float,
    @SerializedName("degrees")
    val degree : Int
)

/*
"wind": {
    "speed": 1.5,
    "deg": 350
}*/
