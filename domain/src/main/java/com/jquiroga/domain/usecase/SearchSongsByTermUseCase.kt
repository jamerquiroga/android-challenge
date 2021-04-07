package com.jquiroga.domain.usecase

import androidx.paging.PagingData
import com.jquiroga.domain.entity.Song
import com.jquiroga.domain.repository.SongRepository
import kotlinx.coroutines.flow.Flow

class SearchSongsByTermUseCase(private val songRepository: SongRepository) {

    suspend operator fun invoke(searchTerm: String): Flow<PagingData<Song>> {
        return songRepository.searchSongsByTerm(searchTerm, PAGE_SIZE)
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}