package com.jquiroga.challenge.features.searchhistory.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jquiroga.challenge.core.failure.FailureMapper
import com.jquiroga.challenge.core.utils.safeLaunch
import com.jquiroga.challenge.core.utils.with
import com.jquiroga.domain.usecase.GetSearchHistoryUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class SearchHistoryViewModel(
    private val getSearchHistoryUseCase: GetSearchHistoryUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _viewState = MutableLiveData<SearchHistoryViewState>()

    val viewState: LiveData<SearchHistoryViewState>
        get() = _viewState

    fun getSearchHistory() {
        viewModelScope.safeLaunch(::exceptionHandler) {
            with(dispatcher) {
                val searchHistory = getSearchHistoryUseCase.invoke()
                _viewState.postValue(SearchHistoryViewState.SuccessGetSearchHistory(searchHistory))
            }

        }
    }

    private fun exceptionHandler(throwable: Throwable) {
        val failure = FailureMapper().map(throwable)
        _viewState.postValue(SearchHistoryViewState.Failure(failure))
    }

}