package com.diousk.scopeddagger

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diousk.scopeddagger.deps.SessionManager
import com.diousk.scopeddagger.deps.UserPrefs
import kotlinx.android.synthetic.main.activity_third.*
import timber.log.Timber
import javax.inject.Inject

class ThirdActivity : DaggerSessionActivity() {
    @Inject
    lateinit var sessionManager: SessionManager

    @Inject
    lateinit var userPrefs: UserPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        Timber.d("userPrefs = $userPrefs")
        Timber.d("sessionManager = $sessionManager")

        btnGoMain.setOnClickListener {
            sessionManager.logout()
            startActivity(Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            })
        }
    }
}