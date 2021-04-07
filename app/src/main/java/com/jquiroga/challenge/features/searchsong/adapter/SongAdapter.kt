package com.jquiroga.challenge.features.searchsong.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jquiroga.challenge.databinding.ItemSongBinding
import com.jquiroga.challenge.features.searchsong.model.SongModel

class SongAdapter : PagingDataAdapter<SongModel, SongAdapter.SongViewHolder>(REPO_COMPARATOR) {

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<SongModel>() {
            override fun areItemsTheSame(oldItem: SongModel, newItem: SongModel): Boolean =
                oldItem.songCode == newItem.songCode

            override fun areContentsTheSame(oldItem: SongModel, newItem: SongModel): Boolean =
                oldItem == newItem
        }
    }

    private var songAdapterListener: SongAdapterListener? = null

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = getItem(position)
        song?.let {
            holder.bind(it)
        }
    }

    fun setListener(listener: SongAdapterListener) {
        songAdapterListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SongViewHolder(
        ItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    inner class SongViewHolder(private val binding: ItemSongBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(songModel: SongModel) {
            binding.run {
                textSongName.text = songModel.songName
                textBandName.text = songModel.bandName

                root.setOnClickListener {
                    songAdapterListener?.onClickSong(songModel.songCode)
                }
            }
        }
    }

}