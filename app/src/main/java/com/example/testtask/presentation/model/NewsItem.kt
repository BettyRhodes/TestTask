package com.example.testtask.presentation.model

import java.util.*

data class NewsItem(
    val id: Int,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String
)

