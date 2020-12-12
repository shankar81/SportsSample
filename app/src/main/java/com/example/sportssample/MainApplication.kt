package com.example.sportssample

import android.app.Application

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MainRepository.initialize(applicationContext)
    }
}