package com.diousk.scopeddagger.di.user

import com.diousk.scopeddagger.deps.UserPrefs
import com.diousk.scopeddagger.di.scope.LoggedUserScope
import dagger.Module
import dagger.Provides

@Module
class UserModule {
    @LoggedUserScope
    @Provides
    fun provideUserPrefs() : UserPrefs {
        return UserPrefs()
    }
}