package com.diousk.scopeddagger

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diousk.scopeddagger.deps.UserPrefs
import kotlinx.android.synthetic.main.activity_second.*
import timber.log.Timber
import javax.inject.Inject

class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var userPrefs: UserPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        val sessionManager = (application as App).appComponent.sessionManager()
        Timber.d("sessionManager = $sessionManager")
        sessionManager.userComponent?.injector()?.inject(this)
        Timber.d("userPrefs = $userPrefs")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnGoThird.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
    }
}