package com.diousk.scopeddagger

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import com.diousk.scopeddagger.deps.UserPrefs
import kotlinx.android.synthetic.main.activity_second.*
import timber.log.Timber
import javax.inject.Inject

class SecondActivity : DaggerSessionActivity() {

    @Inject
    lateinit var userPrefs: UserPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Timber.d("userPrefs = $userPrefs")

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