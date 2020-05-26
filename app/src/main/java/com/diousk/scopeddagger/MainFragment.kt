package com.diousk.scopeddagger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diousk.scopeddagger.deps.SessionManager
import com.diousk.scopeddagger.deps.SessionPrefs
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    @Inject
    lateinit var sessionManager: SessionManager

    @Inject
    lateinit var sessionPrefs: SessionPrefs

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("main fragment sessionPrefs = $sessionPrefs")
    }
}