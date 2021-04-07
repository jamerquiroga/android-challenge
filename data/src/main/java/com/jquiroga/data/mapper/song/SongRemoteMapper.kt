package com.jquiroga.data.mapper.song

import com.jquiroga.data.core.mapper.SingleMapper
import com.jquiroga.data.entity.SongEntity
import com.jquiroga.domain.entity.Song

class SongRemoteMapper : SingleMapper<SongEntity, Song>() {

    override fun map(value: SongEntity) = Song(
        code = value.code,
        name = value.name,
        albumName = value.albumName,
        bandName = value.bandName,
        imageUrl = value.imageUrl
    )
}