package com.example.testtask.data.database

import androidx.room.TypeConverter
import java.util.*



class Converter {
    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return if (timestamp == null) null else Date(timestamp)
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? = date?.time
}