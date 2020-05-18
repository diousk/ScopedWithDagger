package com.diousk.scopeddagger.di.module

import com.diousk.scopeddagger.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun bindLoginActivity(): LoginActivity
}