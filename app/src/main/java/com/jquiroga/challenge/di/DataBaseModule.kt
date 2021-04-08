package com.jquiroga.challenge.di

import com.jquiroga.data.datasource.local.db.ChallengeAppDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single { ChallengeAppDataBase.getInstance(context = androidContext()) }

    single { get<ChallengeAppDataBase>().searchDao() }

    single { get<ChallengeAppDataBase>().songDao() }
}