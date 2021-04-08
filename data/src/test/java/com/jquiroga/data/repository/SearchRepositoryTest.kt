package com.jquiroga.data.repository

import com.jquiroga.data.datasource.local.source.SearchLocalDataSource
import com.jquiroga.data.mapper.search.SearchLocalMapper
import com.jquiroga.data.provider.SearchHistoryDataProvider
import com.jquiroga.domain.repository.SearchRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchRepositoryTest {

    private val searchLocalDataSource by lazy { mockk<SearchLocalDataSource>() }
    private val searchLocalMapper by lazy { SearchLocalMapper() }

    private lateinit var searchRepository: SearchRepository

    @Before
    fun setup() {
        searchRepository = SearchDataRepository(searchLocalDataSource, searchLocalMapper)
    }

    @Test
    fun `check that the functions for saving search terms are called`() = runBlockingTest {
        coEvery { searchLocalDataSource.saveSearchTerm(any()) } returns Unit

        searchRepository.saveSearchTerm(SearchHistoryDataProvider.searchTermDummy())

        coVerify(exactly = 1) { searchLocalDataSource.saveSearchTerm(any()) }
    }

    @Test
    fun `check that the functions to get the search terms are called`() = runBlockingTest {
        coEvery { searchLocalDataSource.getAllSearch() } returns SearchHistoryDataProvider.searchHistoryRoomDummy()

        searchRepository.getAllSearchTerms()

        coVerify(exactly = 1) { searchLocalDataSource.getAllSearch() }
    }

}