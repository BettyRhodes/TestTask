package com.example.testtask.presentation.converter

import com.example.testtask.domain.entity.News
import com.example.testtask.presentation.model.NewsItem
import javax.inject.Inject

class PresentationDatabaseConverter @Inject constructor():
    PresentationConverter<@JvmSuppressWildcards List<News>,@JvmSuppressWildcards List<NewsItem>>{

    override fun convertTo(t: List<News>): List<NewsItem> = t.map {
        NewsItem(
            it.id,
            it.title,
            it.description,
            it.url,
            it.urlToImage,
            it.publishedAt
        )
    }
}