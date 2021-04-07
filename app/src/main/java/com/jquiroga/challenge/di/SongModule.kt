package com.jquiroga.challenge.di

import com.jquiroga.data.datasource.remote.source.SongPagingRemoteDataSource
import com.jquiroga.data.mapper.song.SongRemoteMapper
import com.jquiroga.data.repository.SongDataRepository
import com.jquiroga.domain.repository.SongRepository
import org.koin.dsl.module

val songModule = module {

    factory { SongRemoteMapper() }

    factory { (searchTerm: String) ->
        SongPagingRemoteDataSource(
            searchTerm = searchTerm,
            searchApi = get(),
            songRemoteMapper = get()
        )
    }

    single<SongRepository> {
        SongDataRepository()
    }
}