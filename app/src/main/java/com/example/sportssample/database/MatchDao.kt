package com.example.sportssample.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sportssample.models.Entry
import com.example.sportssample.models.MatchData
import com.example.sportssample.models.Player
import java.util.*

@Dao
interface MatchDao {

    @Insert
    fun addMatch(match: MatchData)

    @Query("SELECT * FROM matches")
    fun getMatches(): LiveData<List<MatchData>>
}