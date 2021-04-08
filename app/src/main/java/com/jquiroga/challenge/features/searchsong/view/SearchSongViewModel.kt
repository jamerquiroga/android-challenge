package com.jquiroga.challenge.features.searchsong.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.paging.map
import com.jquiroga.challenge.core.failure.FailureMapper
import com.jquiroga.challenge.features.searchsong.mapper.SongMapper
import com.jquiroga.challenge.features.searchsong.model.SongModel
import com.jquiroga.domain.usecase.SaveSearchTermUseCase
import com.jquiroga.domain.usecase.SearchSongsByTermUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class SearchSongViewModel(
    private val searchSongsByTermUseCase: SearchSongsByTermUseCase,
    private val saveSearchTermUseCase: SaveSearchTermUseCase,
    private val songMapper: SongMapper,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _errorMessage = MutableLiveData<String>()

    private val errorMessage: LiveData<String>
        get() = _errorMessage

    suspend fun searchSongs(searchTerm: String): Flow<PagingData<SongModel>> {
        saveSearchTerm(searchTerm)
        return searchSongsByTerm(searchTerm)
    }

    private suspend fun saveSearchTerm(searchTerm: String) {
        saveSearchTermUseCase.invoke(searchTerm)
    }

    private suspend fun searchSongsByTerm(searchTerm: String): Flow<PagingData<SongModel>> {
        return searchSongsByTermUseCase.invoke(searchTerm).map { pagingData ->
            pagingData.map { songMapper.map(it) }
        }.catch { e -> exceptionHandler(e) }.flowOn(dispatcher)
    }

    private fun exceptionHandler(t: Throwable) {
        val failure = FailureMapper().map(t)
        _errorMessage.postValue(failure.message)
    }

}