package com.example.sportssample.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import kotlin.collections.HashMap

@Entity(tableName = "matches")
data class MatchData(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val Matchdetail: Any,
    val Nuggets: Array<String>,
    val Innings: Any,
    val Teams: HashMap<String, Entry>,
    val Notes: Any
) {
    // Auto created methods
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MatchData

        if (Matchdetail != other.Matchdetail) return false
        if (!Nuggets.contentEquals(other.Nuggets)) return false
        if (Innings != other.Innings) return false
        if (Teams != other.Teams) return false
        if (Notes != other.Notes) return false

        return true
    }

    // Auto created methods
    override fun hashCode(): Int {
        var result = Matchdetail.hashCode()
        result = 31 * result + Nuggets.contentHashCode()
        result = 31 * result + Innings.hashCode()
        result = 31 * result + Teams.hashCode()
        result = 31 * result + Notes.hashCode()
        return result
    }
}
