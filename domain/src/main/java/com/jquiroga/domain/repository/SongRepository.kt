package com.jquiroga.domain.repository

import androidx.paging.PagingData
import com.jquiroga.domain.entity.Song
import kotlinx.coroutines.flow.Flow

interface SongRepository {

    suspend fun searchSongsByTerm(searchTerm: String, pageSize: Int): Flow<PagingData<Song>>
}