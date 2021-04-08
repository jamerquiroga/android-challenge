package com.jquiroga.challenge.application

import android.app.Application
import com.jquiroga.challenge.BuildConfig
import com.jquiroga.challenge.di.injectModules
import timber.log.Timber

class ChallengeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        injectModules(this)
        initLogging()
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}