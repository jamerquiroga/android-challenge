package com.jquiroga.challenge.feature.searchhistory.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.jquiroga.challenge.core.rules.CoroutineTestRule
import com.jquiroga.challenge.core.rules.runBlockingTest
import com.jquiroga.challenge.features.searchhistory.view.SearchHistoryViewModel
import com.jquiroga.challenge.features.searchhistory.view.SearchHistoryViewState
import com.jquiroga.challenge.provider.SearchHistoryDataProvider
import com.jquiroga.domain.usecase.GetSearchHistoryUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchHistoryViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    private val getSearchHistoryUseCase by lazy { mockk<GetSearchHistoryUseCase>() }

    private lateinit var viewModel: SearchHistoryViewModel

    private val observer = mockk<Observer<SearchHistoryViewState>>(relaxed = true)

    @Before
    fun setup() {
        viewModel = SearchHistoryViewModel(getSearchHistoryUseCase)
        viewModel.viewState.observeForever(observer)
    }

    @Test
    fun `check if SuccessGetSearchHistory state was called`() = coroutineRule.runBlockingTest {

        coEvery { getSearchHistoryUseCase.invoke() } returns SearchHistoryDataProvider.searchHistoryDummy()

        viewModel.getSearchHistory()

        coVerify { getSearchHistoryUseCase.invoke() }

        viewModel.viewState.value shouldBeInstanceOf SearchHistoryViewState.SuccessGetSearchHistory::class.java

    }

}