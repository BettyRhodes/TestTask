package com.example.testtask.dagger.module.presentation

import com.example.testtask.dagger.ActivityScope
import com.example.testtask.presentation.screen.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModules::class])
    fun provideMainActivity(): MainActivity
}