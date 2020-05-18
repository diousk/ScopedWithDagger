package com.diousk.scopeddagger.di.session

import com.diousk.scopeddagger.MainActivity
import com.diousk.scopeddagger.MainFragment
import com.diousk.scopeddagger.SettingActivity
import com.diousk.scopeddagger.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SessionActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [SecondModule::class])
    abstract fun bindSecondActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindThirdActivity(): SettingActivity
}

@Module
abstract class SecondModule {
    @ContributesAndroidInjector
    abstract fun bindSecondFragment(): MainFragment
}