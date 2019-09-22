package com.example.testtask.presentation.converter

import com.example.testtask.domain.entity.News
import com.example.testtask.presentation.model.NewsItem
import javax.inject.Inject

class PresentationNewsConverter @Inject constructor() : PresentationConverter<News, NewsItem> {

    override fun convertTo(t: News): NewsItem =
        NewsItem(
            t.id,
            t.title,
            t.description,
            t.url,
            t.urlToImage,
            t.publishedAt
        )
}