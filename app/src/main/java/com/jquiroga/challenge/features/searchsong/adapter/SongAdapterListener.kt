package com.jquiroga.challenge.features.searchsong.adapter

import com.jquiroga.challenge.features.searchsong.model.SongModel

interface SongAdapterListener {
    fun onClickSong(songModel: SongModel)
}