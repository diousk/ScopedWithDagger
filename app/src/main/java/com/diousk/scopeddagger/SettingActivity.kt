package com.diousk.scopeddagger

import android.content.Intent
import android.os.Bundle
import com.diousk.scopeddagger.deps.SessionManager
import com.diousk.scopeddagger.deps.SessionPrefs
import com.diousk.scopeddagger.di.session.DaggerSessionActivity
import kotlinx.android.synthetic.main.activity_setting.*
import timber.log.Timber
import javax.inject.Inject

class SettingActivity : DaggerSessionActivity() {
    @Inject
    lateinit var sessionManager: SessionManager

    @Inject
    lateinit var sessionPrefs: SessionPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        Timber.d("sessionPrefs = $sessionPrefs")
        Timber.d("sessionManager = $sessionManager")

        btnGoMain.setOnClickListener {
            sessionManager.logout()
            startActivity(Intent(this, LoginActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            })
        }
    }
}