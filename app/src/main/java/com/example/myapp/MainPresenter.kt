package com.example.myapp

import androidx.lifecycle.ViewModel

class MainPresenter() : ViewModel(){
    fun getTemperature() : String {
        return "32"
    }
}