package com.example.testtask.domain.repository

import com.example.testtask.domain.entity.News
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable

interface NewsRepository {
    fun getNews(page: Int): Single<List<News>>

    fun insertNews(news: News): Disposable

    fun selectNews(): Single<List<News>>
}