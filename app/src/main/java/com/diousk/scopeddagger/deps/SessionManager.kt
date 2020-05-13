package com.diousk.scopeddagger.deps

import android.content.Context
import com.diousk.scopeddagger.di.session.SessionComponent
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(
    context: Context,
    private val sessionComponentFactory: SessionComponent.Factory
) {
    var sessionComponent: SessionComponent? = null
        private set

    init {
        Timber.d("SessionManager init, sessionComponentFactory = $sessionComponentFactory")
    }

    fun isUserLoggedIn() = sessionComponent != null

    fun logout() {
        Timber.d("SessionManager logout")
        sessionComponent = null
    }

    fun loginUser() {
        Timber.d("SessionManager loginUser")
        userJustLoggedIn()
    }

    private fun userJustLoggedIn() {
        if (sessionComponent == null) {
            sessionComponent = sessionComponentFactory.create()
        }
    }
}