package com.diousk.scopeddagger

import android.content.Intent
import android.os.Bundle
import com.diousk.scopeddagger.deps.SessionManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import timber.log.Timber
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {

    @Inject lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Timber.d("login sessionManager = $sessionManager")

        goMain.setOnClickListener {
            sessionManager.loginUser()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
