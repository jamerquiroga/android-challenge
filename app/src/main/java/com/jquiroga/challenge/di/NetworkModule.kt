package com.jquiroga.challenge.di

import com.jquiroga.data.datasource.remote.api.SearchApi
import com.jquiroga.data.datasource.remote.api.client.provideApi
import org.koin.dsl.module

val networkModule = module {
    single { provideApi<SearchApi>() }
}