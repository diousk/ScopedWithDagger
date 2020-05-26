package com.diousk.scopeddagger

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.add
import com.diousk.scopeddagger.deps.SessionPrefs
import com.diousk.scopeddagger.di.session.DaggerSessionActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : DaggerSessionActivity() {

    @Inject
    lateinit var sessionPrefs: SessionPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.d("main sessionPrefs = $sessionPrefs")

        goSetting.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))
        }

        openFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add<MainFragment>(R.id.container)
                .addToBackStack(null)
                .commit()
        }
    }
}