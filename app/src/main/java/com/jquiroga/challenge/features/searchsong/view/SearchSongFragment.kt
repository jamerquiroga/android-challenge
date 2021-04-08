package com.jquiroga.challenge.features.searchsong.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.jquiroga.challenge.R
import com.jquiroga.challenge.core.extensions.gone
import com.jquiroga.challenge.core.extensions.visible
import com.jquiroga.challenge.core.platform.BaseFragment
import com.jquiroga.challenge.databinding.FragmentSearchSongBinding
import com.jquiroga.challenge.features.searchsong.adapter.SongAdapterListener
import com.jquiroga.challenge.features.searchsong.adapter.SongLoadStateAdapter
import com.jquiroga.challenge.features.searchsong.adapter.SongsAdapter
import com.jquiroga.challenge.features.searchsong.model.SongModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchSongFragment : BaseFragment() {

    companion object {
        const val TIME_WAITING_SEARCH = 1000L
    }

    private var _viewBinding: FragmentSearchSongBinding? = null

    private val viewBinding get() = _viewBinding!!

    private val viewModel by viewModel<SearchSongViewModel>()

    private val songsAdapter by lazy { SongsAdapter() }

    private var searchJob: Job? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentSearchSongBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun initUI() {
        initListeners()

        viewBinding.recyclerSongs.adapter =
                songsAdapter.withLoadStateFooter(footer = SongLoadStateAdapter {
                    songsAdapter.retry()
                })
    }

    private fun initListeners() {

        viewBinding.textInputEditSearch.doOnTextChanged { text, _, _, _ ->

            searchJob?.cancel()

            searchJob = lifecycleScope.launch {

                viewBinding.recyclerSongs.gone()

                if (text.toString().isEmpty()) {
                    showMessage(getString(R.string.search_song_write_a_song))
                    viewBinding.progressLoading.gone()
                } else {
                    viewBinding.progressLoading.visible()

                    delay(TIME_WAITING_SEARCH)
                    searchSongs(text.toString())
                }
            }
        }

        songsAdapter.addLoadStateListener {
            when (it.source.refresh) {
                is LoadState.NotLoading -> {
                    viewBinding.progressLoading.gone()

                    if (it.append.endOfPaginationReached && songsAdapter.itemCount < 1) {
                        showMessage(getString(R.string.search_song_no_results_for_your_search))
                    } else {
                        viewBinding.recyclerSongs.visible()
                    }
                }

                is LoadState.Loading -> {
                    viewBinding.recyclerSongs.gone()
                    viewBinding.progressLoading.visible()
                }

                is LoadState.Error -> {
                    showMessage(getString(R.string.search_song_error_finding_song))
                    viewBinding.progressLoading.gone()
                }
            }
        }

        songsAdapter.setListener(object : SongAdapterListener {
            override fun onClickSong(songModel: SongModel) {
                goToSongDetailFragment(songModel)
            }
        })
    }

    private suspend fun searchSongs(searchTerm: String) {
        viewModel.searchSongs(searchTerm).collectLatest { pagingData ->
            songsAdapter.submitData(pagingData)
        }
    }

    private fun goToSongDetailFragment(songModel: SongModel) {
        val direction = SearchSongFragmentDirections.actionSearchSongFragmentToSongDetailFragment(songModel)
        findNavController().navigate(direction)
    }

}