package com.example.sportssample.models

import kotlin.collections.HashMap

data class Entry(
    val Name_Full: String,
    val Players: HashMap<String, Player>
)