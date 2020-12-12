package com.example.sportssample.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://cricket.yahoo.net"

    fun get(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}