package com.example.testtask.presentation.screen.splashScreen

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.testtask.R
import com.example.testtask.presentation.common.BaseFragment
import javax.inject.Inject

class SplashFragment: BaseFragment(R.layout.fragment_splash), SplashView{

    @Inject
    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter(): SplashPresenter = presenter
}