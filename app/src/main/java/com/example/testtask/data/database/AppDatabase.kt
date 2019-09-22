package com.example.testtask.data.database

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testtask.domain.entity.News

@Database(entities = [News::class], version = AppDatabase.VERSION, exportSchema = false)
@TypeConverters(
    Converter::class,
    ListConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "News.db"
        const val VERSION = 1
    }

    abstract fun newsDao(): NewsDao
}