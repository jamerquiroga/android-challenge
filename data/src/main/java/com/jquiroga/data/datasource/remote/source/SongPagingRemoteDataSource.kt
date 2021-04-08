package com.jquiroga.data.datasource.remote.source

import androidx.paging.PagingSource
import com.jquiroga.data.core.network.safeApiCall
import com.jquiroga.data.datasource.local.source.SongLocalDataSource
import com.jquiroga.data.datasource.remote.api.SearchApi
import com.jquiroga.data.mapper.song.SongRemoteMapper
import com.jquiroga.domain.entity.Song
import com.jquiroga.domain.exception.EmptyDataException

class SongPagingRemoteDataSource(
    private val searchTerm: String,
    private val searchApi: SearchApi,
    private val songRemoteMapper: SongRemoteMapper,
    private val songLocalDataSource: SongLocalDataSource
) : PagingSource<Int, Song>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Song> {
        val page = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = safeApiCall {
                searchApi.search(
                    searchTerm = searchTerm,
                    limitPerPage = params.loadSize,
                    offset = evaluateBeginningOfEachPage(page, params.loadSize)
                )
            }

            response?.let {
                val songList = songRemoteMapper.map(it.results)
                saveSongs(songList)

                LoadResult.Page(
                    data = songList,
                    prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                    nextKey = if (it.results.isEmpty()) null else page + 1
                )
            } ?: LoadResult.Error(EmptyDataException())
        } catch (throwable: Throwable) {
            LoadResult.Error(throwable)
        }
    }

    /**
     * Paging Library: By default, the initial load size is 3 * page size
     * iTunes API: Does not support paging
     * */
    private fun evaluateBeginningOfEachPage(page: Int, loadSize: Int): Int {
        return when (page) {
            INITIAL_PAGE -> 0
            else -> (page + 2) * loadSize
        }
    }

    private suspend fun saveSongs(values: List<Song>) {
        songLocalDataSource.saveSongs(values, searchTerm)
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 0
        private const val INITIAL_PAGE = 0
    }


}