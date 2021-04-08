package com.jquiroga.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jquiroga.data.datasource.remote.source.SongPagingRemoteDataSource
import com.jquiroga.domain.entity.Song
import com.jquiroga.domain.repository.SongRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

class SongDataRepository :
    SongRepository, KoinComponent {

    override suspend fun searchSongsByTerm(
        searchTerm: String,
        pageSize: Int
    ): Flow<PagingData<Song>> {

        val songPagingRemoteDataSource by inject<SongPagingRemoteDataSource> {
            parametersOf(
                searchTerm
            )
        }

        return Pager(
            config = PagingConfig(
                pageSize = pageSize,
                enablePlaceholders = false
            ), pagingSourceFactory = {
                songPagingRemoteDataSource
            }
        ).flow
    }
}