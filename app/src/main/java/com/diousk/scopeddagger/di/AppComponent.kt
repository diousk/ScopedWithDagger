package com.diousk.scopeddagger.di

import com.diousk.scopeddagger.App
import com.diousk.scopeddagger.deps.SessionManager
import com.diousk.scopeddagger.di.module.ActivityBuilder
import com.diousk.scopeddagger.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        AppSubcomponents::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>

    // expose session manager to control lifecycle of UserComponent
    fun sessionManager(): SessionManager
}