package com.jquiroga.challenge.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.module.Module
import org.koin.core.context.startKoin

fun injectModules(app: Application) {
    startKoin {
        androidLogger()
        androidContext(app)
        modules(modules)
    }
}

private val modules = listOf<Module>()