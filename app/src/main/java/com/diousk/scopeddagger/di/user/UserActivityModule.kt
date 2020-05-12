package com.diousk.scopeddagger.di.user

import com.diousk.scopeddagger.SecondActivity
import com.diousk.scopeddagger.SecondFragment
import com.diousk.scopeddagger.ThirdActivity
import com.diousk.scopeddagger.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UserActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [SecondModule::class])
    abstract fun bindSecondActivity(): SecondActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindThirdActivity(): ThirdActivity
}

@Module
abstract class SecondModule {
    @ContributesAndroidInjector
    abstract fun bindSecondFragment(): SecondFragment
}