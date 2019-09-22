package com.example.testtask.presentation.screen.news

import com.arellomobile.mvp.InjectViewState
import com.example.testtask.domain.entity.News
import com.example.testtask.domain.repository.NewsRepository
import com.example.testtask.presentation.common.BasePresenter
import com.example.testtask.presentation.common.Paginator
import com.example.testtask.presentation.converter.PresentationDatabaseConverter
import com.example.testtask.presentation.converter.PresentationNewsConverter
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@InjectViewState
class NewsPresenter @Inject constructor(
    private val newsRepository: NewsRepository,
    private val newsConverter: PresentationNewsConverter,
    private val databaseConverter: PresentationDatabaseConverter
) : BasePresenter<NewsView>() {

    private val paginator = Paginator({
        newsRepository.getNews(it)
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { viewState.hideProgress() }
    },
        object : Paginator.ViewController<News> {
            override fun showEmptyProgress(show: Boolean) {
                viewState.showProgress()
            }

            override fun showEmptyError(show: Boolean, error: Throwable?) {
                viewState.showNetworkError()
            }

            override fun showEmptyView(show: Boolean) {

            }

            override fun showData(show: Boolean, data: List<News>) {

                viewState.showFeed(
                    data.map { newsConverter.convertTo(it) }
                )

                data.forEach { newsRepository.insertNews(it) }
            }

            override fun showErrorMessage(error: Throwable) {

            }

            override fun showRefreshProgress(show: Boolean) {
                viewState.showProgress()
            }

            override fun showPageProgress(show: Boolean) {
                viewState.showProgress()
            }
        }
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        newsRepository.selectNews()
            .doOnSuccess { viewState.showFeed(databaseConverter.convertTo(it)) }
            .subscribe()
            .untilDestroy()
        paginator.refresh()
    }

    fun loadNews() {
        paginator.loadNewPage()
    }

    fun refreshNews() {
        paginator.refresh()
    }

    override fun onDestroy() {
        super.onDestroy()
        paginator.release()
    }
}