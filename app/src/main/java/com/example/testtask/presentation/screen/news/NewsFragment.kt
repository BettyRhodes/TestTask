package com.example.testtask.presentation.screen.news

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.testtask.R
import com.example.testtask.presentation.common.BaseFragment
import com.example.testtask.presentation.common.showSnackbar
import com.example.testtask.presentation.model.NewsItem
import com.example.testtask.presentation.screen.news.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

class NewsFragment : BaseFragment(R.layout.fragment_news), NewsView {

    @Inject
    @InjectPresenter
    lateinit var presenter: NewsPresenter

    @ProvidePresenter
    fun providePresenter(): NewsPresenter = presenter

    private val feedAdapter = NewsAdapter { presenter.loadNews() }

    private fun initFeed() {
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = feedAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFeed()
        feedAdapter.addOnClickRepeat { presenter.refreshNews()}
        presenter.loadNews()
        refreshLayout.setOnRefreshListener(presenter::refreshNews)
    }

    override fun showFeed(news: List<NewsItem>) {
            feedAdapter.setNews(news)
    }

    override fun showNetworkError() {
        recyclerView.showSnackbar("Network error")
    }

    override fun showProgress() {
        refreshLayout.isRefreshing = true
    }

    override fun hideProgress() {
        refreshLayout.isRefreshing = false
    }

    override fun showRepeatButton() {
        feedAdapter.showRepeatButton()
    }
}