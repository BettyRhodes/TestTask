package com.example.testtask.presentation.navigation

import androidx.fragment.app.Fragment
import com.example.testtask.presentation.screen.news.NewsFragment
import com.example.testtask.presentation.screen.splashScreen.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen(fragment: Fragment): BaseScreen(fragment) {
    class SplashScreen: Screen(SplashFragment())
    class NewsScreen: Screen(NewsFragment())
}

open class BaseScreen(private val fragment: Fragment): SupportAppScreen(){
    override fun getFragment(): Fragment = fragment
}