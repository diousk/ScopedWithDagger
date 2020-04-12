package com.diousk.scopeddagger

import android.content.Intent
import android.os.Bundle
import com.diousk.scopeddagger.deps.SessionManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d("sessionManager = $sessionManager")

        btnGoSecond.setOnClickListener {
            sessionManager.loginUser()
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}
