package com.jquiroga.domain

import com.jquiroga.domain.provider.SearchHistoryDataProvider
import com.jquiroga.domain.repository.SearchRepository
import com.jquiroga.domain.usecase.SaveSearchTermUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SaveSearchTermUseCaseTest {

    private val searchRepository by lazy { mockk<SearchRepository>(relaxed = true) }

    private lateinit var saveSearchTermUseCase: SaveSearchTermUseCase

    @Before
    fun setup() {
        saveSearchTermUseCase = SaveSearchTermUseCase(searchRepository)
    }

    @Test
    fun `check that the function to save the search terms is called`() = runBlockingTest {

        coEvery { searchRepository.saveSearchTerm(any()) } returns Unit

        saveSearchTermUseCase.invoke(SearchHistoryDataProvider.searchTermDummy())

        coVerify(exactly = 1) { searchRepository.saveSearchTerm(any()) }
    }

}