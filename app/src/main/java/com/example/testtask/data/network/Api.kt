package com.example.testtask.data.network

import com.example.testtask.data.response.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("everything?q=android&from=2019-04-00&sortBy=publishedAt&apiKey=26eddb253e7840f988aec61f2ece2907")
    fun getNews(@Query("page") page: Int): Single<NewsResponse>
}