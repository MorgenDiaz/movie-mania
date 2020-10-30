package com.webslinger.portfolio.moviemania.data.db

import androidx.room.TypeConverter
import org.json.JSONException
import org.json.JSONObject

class Converters {
    @TypeConverter
    fun fromStringToInts(value: String?): List<Int>?{
        return value?.let {
            if(value.isBlank())
                return listOf()

            it.split(":").map{strValue ->
                strValue.toInt()
            }
        }
    }

    @TypeConverter
    fun fromIntsToString(value: List<Int>?): String?{
        return value?.joinToString(":")
    }

    @TypeConverter
    fun fromStringsToJsonString(value: List<String>?): String?{
        return JSONObject()
            .put("strings", value)
            .toString()
    }

    @TypeConverter
    fun fromJsonStringToStrings(value: String?): List<String>?{
        try {
            val jsonStrings = JSONObject(value).getJSONArray("strings")

            return List<String>(jsonStrings.length()) {
                jsonStrings.getString(it)
            }
        }
        catch (e: JSONException){
            return listOf()
        }
    }
}