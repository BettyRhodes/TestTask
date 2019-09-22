package com.example.testtask.presentation.screen.news

import com.arellomobile.mvp.MvpView
import com.example.testtask.presentation.model.NewsItem

interface NewsView: MvpView {

    fun showFeed(news: List<NewsItem>)

    fun showNetworkError()

    fun showProgress()

    fun hideProgress()

    fun showButton()
}