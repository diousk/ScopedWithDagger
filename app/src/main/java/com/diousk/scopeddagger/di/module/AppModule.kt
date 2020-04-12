package com.diousk.scopeddagger.di.module

import android.content.Context
import com.diousk.scopeddagger.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun bindContext(app: App): Context = app.applicationContext
}