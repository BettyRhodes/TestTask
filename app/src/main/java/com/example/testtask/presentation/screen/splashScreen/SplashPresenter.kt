package com.example.testtask.presentation.screen.splashScreen

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.example.testtask.presentation.common.BasePresenter
import com.example.testtask.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class SplashPresenter @Inject constructor(private val router: Router): BasePresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Handler().postDelayed({
            router.newRootScreen(Screen.NewsScreen())
        }, 2000)
    }
}