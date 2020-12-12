package com.example.sportssample.network

import com.example.sportssample.models.MatchData
import retrofit2.Call
import retrofit2.http.GET

interface SportsAPI {

    @GET("/sifeeds/cricket/live/json/sapk01222019186652.json")
    fun getSportsData(): Call<MatchData>
}