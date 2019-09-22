package com.example.testtask.dagger.module.data

import com.example.testtask.data.converter.Converter
import com.example.testtask.data.converter.DatabaseInsertConverter
import com.example.testtask.data.converter.NewsConverter
import com.example.testtask.data.response.NewsEntity
import com.example.testtask.data.response.NewsResponse
import com.example.testtask.domain.entity.News
import com.example.testtask.presentation.converter.PresentationConverter
import com.example.testtask.presentation.converter.PresentationNewsConverter
import com.example.testtask.presentation.model.NewsItem
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface ConverterModule {

    @Reusable
    @Binds
    fun bindNewsConverter(instance: NewsConverter): Converter<NewsResponse, List<News>>

    @Reusable
    @Binds
    fun bindDatabaseNewsConverter(instance: Converter<News, News>): Converter<News, News>

    @Reusable
    @Binds
    fun bindPresentationNewsConverter(instance: PresentationNewsConverter): PresentationConverter<News, NewsItem>

    @Reusable
    @Binds
    fun bindDatabaseInsertConverter(instance: DatabaseInsertConverter): Converter<NewsEntity, News>
}