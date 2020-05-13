package com.diousk.scopeddagger.di.session

import com.diousk.scopeddagger.deps.SessionPrefs
import com.diousk.scopeddagger.di.scope.SessionScope
import dagger.Module
import dagger.Provides

@Module
class SessionModule {
    @SessionScope
    @Provides
    fun provideSessionPrefs() : SessionPrefs {
        return SessionPrefs()
    }
}