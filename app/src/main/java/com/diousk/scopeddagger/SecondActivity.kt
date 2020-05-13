package com.diousk.scopeddagger

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.add
import com.diousk.scopeddagger.deps.SessionPrefs
import com.diousk.scopeddagger.di.session.DaggerSessionActivity
import kotlinx.android.synthetic.main.activity_second.*
import timber.log.Timber
import javax.inject.Inject

class SecondActivity : DaggerSessionActivity() {

    @Inject
    lateinit var sessionPrefs: SessionPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Timber.d("sessionPrefs = $sessionPrefs")

        btnGoThird.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        btnGoFrag.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add<SecondFragment>(R.id.container)
                .addToBackStack(null)
                .commit()
        }
    }
}