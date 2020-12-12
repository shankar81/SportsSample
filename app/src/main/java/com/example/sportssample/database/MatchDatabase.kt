package com.example.sportssample.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sportssample.models.Entry
import com.example.sportssample.models.MatchData
import com.example.sportssample.models.Player

/** NOTE
 *
 * Database is not working
 * I got stuck while saving HashMap to Room database.
 * So i commented it out.
 *
 */

//@TypeConverters(MatchTypeConverter::class)
//@Database(entities = [MatchData::class], version = 1)
abstract class MatchDatabase : RoomDatabase() {
    // This method will be implemented by Room
    abstract fun matchDao(): MatchDao
}