package com.example.sportssample.database

import androidx.room.TypeConverter
import com.example.sportssample.models.Entry
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import java.util.*
import kotlin.collections.HashMap

class MatchTypeConverter {

    @TypeConverter
    fun toMap(value: JsonElement): HashMap<String, Entry> {
        return Gson().fromJson(value, object : TypeToken<HashMap<String, Entry>>() {}.type)
    }

    @TypeConverter
    fun fromMap(value: HashMap<String, Entry>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toArray(value: JsonElement): Array<String> {
        return Gson().fromJson(value, object : TypeToken<Array<String>>() {}.type)
    }

    @TypeConverter
    fun fromArray(value: Array<String>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID): String {
        return uuid.toString()
    }

    @TypeConverter
    fun toUUID(uuid: String): UUID {
        return UUID.fromString(uuid)
    }

}