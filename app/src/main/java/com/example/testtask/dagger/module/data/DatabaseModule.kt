package com.example.testtask.dagger.module.data

import android.app.Application
import androidx.room.Room
import com.example.testtask.App
import com.example.testtask.data.database.AppDatabase
import com.example.testtask.data.database.NewsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: App): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUserDao(appDataBase: AppDatabase): NewsDao {
        return appDataBase.newsDao()
    }
}