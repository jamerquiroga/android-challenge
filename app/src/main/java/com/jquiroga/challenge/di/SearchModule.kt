package com.jquiroga.challenge.di

import com.jquiroga.data.datasource.local.source.SearchLocalDataSource
import org.koin.dsl.module

val searchModule = module {

    single {
        SearchLocalDataSource(searchDao = get())
    }
}