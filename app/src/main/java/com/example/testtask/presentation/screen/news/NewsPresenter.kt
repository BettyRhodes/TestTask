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

    // да, это смешно
    private val lastPage = 6
    private var page = 0

    private val paginator = Paginator({
        page = it
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

                newsRepository.selectNews()
                    .doOnSuccess { viewState.showFeed(databaseConverter.convertTo(it)) }
                    .subscribe()
                    .untilDestroy()
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
                if(page != lastPage)
                    viewState.showRepeatButton()
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