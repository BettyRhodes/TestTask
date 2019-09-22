package com.example.testtask.data.response

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("articles") val articles: List<NewsEntity>
)