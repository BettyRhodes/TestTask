package com.example.testtask.dagger.module.data

import com.example.testtask.data.converter.Converter
import com.example.testtask.data.database.AppDatabase
import com.example.testtask.data.network.Api
import com.example.testtask.data.repository.RepositoryImpl
import com.example.testtask.data.response.NewsResponse
import com.example.testtask.domain.entity.News
import com.example.testtask.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        NetworkModule::class,
        ConverterModule::class,
        DatabaseModule::class
    ]
)
class DataModule {

    @Provides
    @Singleton
    fun bindFeedRepository(
        api: Api,
        converter: Converter<NewsResponse, List<News>>,
        database: AppDatabase
    ): NewsRepository =
        RepositoryImpl(api, converter, database)


}