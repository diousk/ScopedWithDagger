package com.diousk.scopeddagger

import com.diousk.scopeddagger.di.AppComponent
import com.diousk.scopeddagger.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class App : DaggerApplication() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this) as AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }
}