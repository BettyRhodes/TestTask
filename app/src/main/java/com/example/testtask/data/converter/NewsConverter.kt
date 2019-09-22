package com.example.testtask.data.converter

import com.example.testtask.data.response.NewsResponse
import com.example.testtask.domain.entity.News
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class NewsConverter @Inject constructor() : Converter<NewsResponse, @JvmSuppressWildcards List<News>> {

    override fun convertTo(t: NewsResponse): List<News> = t.articles.map {
        News(
            it.id,
            it.title,
            it.description,
            it.url,
            it.urlToImage,
            convertDate(it.publishedAt)
        )
    }

    private fun convertDate(date: Date): String =
        SimpleDateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault()).format(date)
}