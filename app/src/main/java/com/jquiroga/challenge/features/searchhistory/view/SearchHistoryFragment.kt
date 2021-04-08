package com.jquiroga.challenge.features.searchhistory.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jquiroga.challenge.core.platform.BaseFragment
import com.jquiroga.challenge.databinding.FragmentSearchHistoryBinding


class SearchHistoryFragment : BaseFragment() {

    private var _viewBinding: FragmentSearchHistoryBinding? = null

    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _viewBinding = FragmentSearchHistoryBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun initUI() {

    }

    override fun initObservers() {

    }

}