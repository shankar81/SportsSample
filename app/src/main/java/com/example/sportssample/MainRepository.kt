package com.example.sportssample

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sportssample.models.MatchData
import com.example.sportssample.network.APIService
import com.example.sportssample.network.SportsAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(context: Context) {

    fun getMatchDetails(): LiveData<MatchData> {
        val sportsMutableLiveData = MutableLiveData<MatchData>()

        APIService.get().create(SportsAPI::class.java).getSportsData().enqueue(object :
            Callback<MatchData> {
            override fun onResponse(call: Call<MatchData>, response: Response<MatchData>) {
                if (response.isSuccessful) {
                    sportsMutableLiveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<MatchData>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return sportsMutableLiveData
    }


    companion object {
        private var INSTANCE: MainRepository? = null

        fun initialize(context: Context) {
            INSTANCE = MainRepository(context)
        }

        // Must initialize the Repo first before accessing
        fun getRepository() = INSTANCE ?: throw IllegalStateException("Initialization Error")
    }
}