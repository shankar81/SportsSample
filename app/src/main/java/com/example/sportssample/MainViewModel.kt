package com.example.sportssample

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val repository = MainRepository.getRepository()

    fun getMatchDetails() = repository.getMatchDetails()
}