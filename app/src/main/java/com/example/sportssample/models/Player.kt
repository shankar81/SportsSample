package com.example.sportssample.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Player(
    @Expose
    @SerializedName("Name_Full")
    val name: String = "",
    @Expose
    @SerializedName("Iscaptain")
    val isCaptain: Boolean = false,
    @Expose
    @SerializedName("Iskeeper")
    val isKeeper: Boolean = false
)