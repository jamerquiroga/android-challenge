package com.jquiroga.data.mapper.song

import com.jquiroga.data.core.mapper.SingleMapper
import com.jquiroga.data.datasource.local.db.entity.SongRoom
import com.jquiroga.domain.entity.Song

class SongLocalMapper : SingleMapper<SongRoom, Song>() {

    override fun map(value: SongRoom) = Song(
        code = value.code,
        name = value.name,
        albumName = value.albumName,
        bandName = value.bandName,
        imageUrl = value.imageUrl
    )

    fun customMap(songList: List<Song>, searchTerm: String): List<SongRoom> {
        return songList.map { song ->
            SongRoom(
                code = song.code,
                name = song.name,
                albumName = song.albumName,
                bandName = song.bandName,
                imageUrl = song.imageUrl,
                searchTerm = searchTerm
            )
        }
    }

}