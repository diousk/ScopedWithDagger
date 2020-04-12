package com.diousk.scopeddagger.di.user

import android.app.Activity
import com.diousk.scopeddagger.di.scope.LoggedUserScope
import dagger.Subcomponent
import dagger.android.DispatchingAndroidInjector

@LoggedUserScope
@Subcomponent(modules = [UserActivityModule::class, UserModule::class])
interface UserComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): UserComponent
    }

    fun injector(): DispatchingAndroidInjector<Activity>
}