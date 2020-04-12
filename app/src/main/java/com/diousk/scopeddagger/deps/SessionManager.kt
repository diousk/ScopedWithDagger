package com.diousk.scopeddagger.deps

import android.content.Context
import com.diousk.scopeddagger.di.user.UserComponent
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(
    context: Context,
    private val userComponentFactory: UserComponent.Factory
) {
    var userComponent: UserComponent? = null
        private set

    init {
        Timber.d("SessionManager init, userComponentFactory = $userComponentFactory")
    }

    fun isUserLoggedIn() = userComponent != null

    fun logout() {
        Timber.d("SessionManager logout")
        userComponent = null
    }

    fun loginUser() {
        Timber.d("SessionManager loginUser")
        userJustLoggedIn()
    }

    private fun userJustLoggedIn() {
        if (userComponent == null) {
            userComponent = userComponentFactory.create()
        }
    }
}