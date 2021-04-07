package com.jquiroga.challenge.features.searchsong.mapper

import com.jquiroga.challenge.features.searchsong.model.SongModel
import com.jquiroga.data.core.mapper.SingleMapper
import com.jquiroga.domain.entity.Song

class SongMapper : SingleMapper<Song, SongModel>() {

    override fun map(value: Song) = SongModel(
        code = value.code,
        name = value.name,
        albumName = value.albumName,
        bandName = value.bandName,
        imageUrl = value.imageUrl
    )

}