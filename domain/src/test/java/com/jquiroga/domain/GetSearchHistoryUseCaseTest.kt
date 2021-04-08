package com.jquiroga.domain

import com.jquiroga.domain.provider.SearchHistoryDataProvider
import com.jquiroga.domain.repository.SearchRepository
import com.jquiroga.domain.usecase.GetSearchHistoryUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetSearchHistoryUseCaseTest {

    private val searchRepository by lazy { mockk<SearchRepository>(relaxed = true) }

    private lateinit var getSearchHistoryUseCase: GetSearchHistoryUseCase

    @Before
    fun setup() {
        getSearchHistoryUseCase = GetSearchHistoryUseCase(searchRepository)
    }

    @Test
    fun `check that the function to get the search terms are called`() = runBlockingTest {
        coEvery { searchRepository.getAllSearchTerms() } returns SearchHistoryDataProvider.searchHistoryDummy()

        getSearchHistoryUseCase.invoke()

        coVerify(exactly = 1) { searchRepository.getAllSearchTerms() }
    }

}