package com.example.testtask.data.database

import androidx.room.TypeConverter
import com.example.testtask.data.response.NewsEntity
import com.example.testtask.domain.entity.News
import com.google.gson.reflect.TypeToken
import java.util.Collections.emptyList
import com.google.gson.Gson
import java.util.*


class ListConverter {

    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<News> {
        if (data == null)
            return emptyList()

        val listType = object : TypeToken<List<News>>() {}.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<News>): String =
        gson.toJson(someObjects)

}