package com.jquiroga.challenge.di

import com.jquiroga.challenge.features.searchhistory.view.SearchHistoryViewModel
import com.jquiroga.data.datasource.local.source.SearchLocalDataSource
import com.jquiroga.data.mapper.search.SearchLocalMapper
import com.jquiroga.data.repository.SearchDataRepository
import com.jquiroga.domain.repository.SearchRepository
import com.jquiroga.domain.usecase.GetSearchHistoryUseCase
import com.jquiroga.domain.usecase.SaveSearchTermUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModule = module {

    factory { SearchLocalMapper() }

    single {
        SearchLocalDataSource(searchDao = get())
    }

    single<SearchRepository> {
        SearchDataRepository(searchLocalDataSource = get(), searchLocalMapper = get())
    }

    factory { SaveSearchTermUseCase(searchRepository = get()) }

    factory { GetSearchHistoryUseCase(searchRepository = get()) }

    viewModel {
        SearchHistoryViewModel(getSearchHistoryUseCase = get())
    }
}