package com.example.testtask.data.repository

import android.util.Log
import com.example.testtask.data.converter.Converter
import com.example.testtask.data.database.AppDatabase
import com.example.testtask.data.network.Api
import com.example.testtask.data.response.NewsResponse
import com.example.testtask.domain.entity.News
import com.example.testtask.domain.repository.NewsRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: Api,
    private val newsConverter: Converter<NewsResponse, List<News>>,
    private val database: AppDatabase
) :
    NewsRepository {

    override fun getNews(page: Int): Single<List<News>> =
        api.getNews(page)
            .subscribeOn(Schedulers.io())
            .map(newsConverter::convertTo)

    override fun insertNews(news: News): Disposable =
        Single
            .fromCallable { database.newsDao().insertNews(news) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

    override fun selectNews(): Single<List<News>> =
        database.newsDao().selectAllNews()
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
    //.map(databaseSelectConverter::convertTo)
    // .observeOn(AndroidSchedulers.mainThread())

}