package com.jquiroga.challenge.di

import com.jquiroga.challenge.features.searchsong.mapper.SongMapper
import com.jquiroga.challenge.features.searchsong.view.SearchSongViewModel
import com.jquiroga.data.datasource.local.source.SongLocalDataSource
import com.jquiroga.data.datasource.remote.source.SongPagingRemoteDataSource
import com.jquiroga.data.mapper.song.SongLocalMapper
import com.jquiroga.data.mapper.song.SongRemoteMapper
import com.jquiroga.data.repository.SongDataRepository
import com.jquiroga.domain.repository.SongRepository
import com.jquiroga.domain.usecase.SearchSongsByTermUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val songModule = module {

    factory { SongRemoteMapper() }
    factory { SongMapper() }
    factory { SongLocalMapper() }

    factory { (searchTerm: String) ->
        SongPagingRemoteDataSource(
            searchTerm = searchTerm,
            searchApi = get(),
            songRemoteMapper = get(),
            songLocalDataSource = get()
        )
    }

    single {
        SongLocalDataSource(
            songDao = get(),
            songLocalMapper = get()
        )
    }

    single<SongRepository> {
        SongDataRepository()
    }

    factory { SearchSongsByTermUseCase(songRepository = get()) }

    viewModel {
        SearchSongViewModel(
            searchSongsByTermUseCase = get(),
            saveSearchTermUseCase = get(),
            songMapper = get()
        )
    }
}