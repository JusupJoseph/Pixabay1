package com.example.pixabay

import android.app.Application

class App : Application() {
    companion object {
        lateinit var api: PixabayApi
    }

    override fun onCreate() {
        super.onCreate()
        api = RetrofitService().api
    }
}