package com.diousk.scopeddagger.di.session

import com.diousk.scopeddagger.di.scope.SessionScope
import dagger.Subcomponent
import dagger.android.DispatchingAndroidInjector

@SessionScope
@Subcomponent(modules = [SessionActivityBuilder::class, SessionModule::class])
interface SessionComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): SessionComponent
    }

    fun injector(): DispatchingAndroidInjector<Any>
}