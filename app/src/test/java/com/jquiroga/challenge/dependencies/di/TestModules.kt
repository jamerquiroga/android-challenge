package com.jquiroga.challenge.dependencies.di

import android.content.Context
import com.jquiroga.challenge.core.utils.listByElementsOf
import com.jquiroga.challenge.di.databaseModule
import com.jquiroga.challenge.di.networkModule
import com.jquiroga.challenge.di.searchModule
import com.jquiroga.challenge.di.songModule
import io.mockk.mockk
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module


internal fun injectTestModules() {
    startKoin {
        printLogger()
        modules(baseTestModules)
    }
}

private val baseTestModules by lazy {
    listByElementsOf<Module>(
        mocksModule,
        networkModule,
        databaseModule,
        songModule,
        searchModule
    )
}

private val mocksModule = module {
    factory(override = true) { mockk<Context>() }
}