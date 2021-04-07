package com.jquiroga.challenge.features.searchsong.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jquiroga.challenge.core.extensions.gone
import com.jquiroga.challenge.core.extensions.visible
import com.jquiroga.challenge.databinding.ItemSongLoadStateBinding

class SongLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<SongLoadStateAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) = ViewHolder(
        ItemSongLoadStateBinding.inflate(LayoutInflater.from(parent.context), parent, false), retry
    )

    inner class ViewHolder(
        private val binding: ItemSongLoadStateBinding,
        private val retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(loadState: LoadState) {
            when (loadState) {
                is LoadState.Loading -> {
                    binding.progressLoading.visible()
                    binding.buttonRetry.gone()
                }
                else -> {
                    binding.buttonRetry.visible()
                    binding.progressLoading.gone()
                }
            }

            binding.buttonRetry.setOnClickListener {
                retry.invoke()
            }
        }

    }
}