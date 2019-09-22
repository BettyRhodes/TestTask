package com.example.testtask.dagger.module.presentation

import com.example.testtask.dagger.FragmentScope
import com.example.testtask.presentation.screen.news.NewsFragment
import com.example.testtask.presentation.screen.splashScreen.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModules {

    @FragmentScope
    @ContributesAndroidInjector
    fun provideNewsFragment(): NewsFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideSplashFragment(): SplashFragment
}