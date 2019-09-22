package com.example.testtask.data.converter

import com.example.testtask.data.response.NewsEntity
import com.example.testtask.data.response.NewsResponse
import com.example.testtask.domain.entity.News
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DatabaseInsertConverter @Inject constructor():
    Converter<NewsEntity, News>{

    override fun convertTo(t: NewsEntity): News =
        News(
            t.id,
            t.title,
            t.description,
            t.url,
            t.urlToImage,
            convertDate(t.publishedAt)
        )

    private fun convertDate(date: Date): String =
        SimpleDateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault()).format(date)
}