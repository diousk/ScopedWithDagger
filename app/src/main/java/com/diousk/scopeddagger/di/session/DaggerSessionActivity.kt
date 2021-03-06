package com.diousk.scopeddagger.di.session

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diousk.scopeddagger.App
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class DaggerSessionActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        val sessionManager = (application as App).appComponent.sessionManager()
        sessionManager.sessionComponent?.injector()?.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}