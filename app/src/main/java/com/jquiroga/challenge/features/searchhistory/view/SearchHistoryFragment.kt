package com.jquiroga.challenge.features.searchhistory.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.jquiroga.challenge.R
import com.jquiroga.challenge.core.failure.FailureModel
import com.jquiroga.challenge.core.platform.BaseFragment
import com.jquiroga.challenge.databinding.FragmentSearchHistoryBinding
import com.jquiroga.challenge.features.searchhistory.adapter.SearchHistoryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchHistoryFragment : BaseFragment() {

    private var _viewBinding: FragmentSearchHistoryBinding? = null

    private val viewBinding get() = _viewBinding!!

    private val viewModel by viewModel<SearchHistoryViewModel>()

    private val searchHistoryAdapter by lazy { SearchHistoryAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _viewBinding = FragmentSearchHistoryBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun initUI() {
        viewModel.getSearchHistory()

        viewBinding.recyclerSearchHistory.adapter = searchHistoryAdapter
    }

    override fun initObservers() {
        viewModel.viewState.observe(this, viewStateObserver)
    }

    private val viewStateObserver = Observer<SearchHistoryViewState> { state ->
        when (state) {
            is SearchHistoryViewState.SuccessGetSearchHistory -> setDataInUI(state.searchHistory)
            is SearchHistoryViewState.Failure -> setErrorInUI(state.failure)
        }
    }

    private fun setDataInUI(searchHistory: List<String>) {
        if (searchHistory.isEmpty()) {
            showMessage(getString(R.string.search_history_your_history_is_empty))
        } else {
            searchHistoryAdapter.addSearchHistory(searchHistory)
        }
    }

    private fun setErrorInUI(failureModel: FailureModel) {
        showMessage(failureModel.message)
    }

}