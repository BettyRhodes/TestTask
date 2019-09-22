package com.example.testtask.dagger

import com.example.testtask.App
import com.example.testtask.dagger.module.data.DataModule
import com.example.testtask.dagger.module.data.DatabaseModule
import com.example.testtask.dagger.module.presentation.AppModule
import com.example.testtask.dagger.module.presentation.NavigationModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NavigationModule::class,
        DataModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Builder : AndroidInjector.Factory<App>
}