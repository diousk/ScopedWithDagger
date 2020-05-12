package com.diousk.scopeddagger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diousk.scopeddagger.deps.SessionManager
import com.diousk.scopeddagger.deps.UserPrefs
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

class SecondFragment : DaggerFragment() {

    @Inject
    lateinit var sessionManager: SessionManager

    @Inject
    lateinit var userPrefs: UserPrefs

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("userPrefs = $userPrefs")
        Timber.d("sessionManager = $sessionManager")
    }
}