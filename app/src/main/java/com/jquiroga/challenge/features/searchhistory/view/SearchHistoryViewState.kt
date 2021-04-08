package com.jquiroga.challenge.features.searchhistory.view

import com.jquiroga.challenge.core.failure.FailureModel

sealed class SearchHistoryViewState {
    class SuccessGetSearchHistory(val searchHistory: List<String>) : SearchHistoryViewState()
    class Failure(val failure: FailureModel) : SearchHistoryViewState()
}