package com.jquiroga.data.datasource.local.source

import com.jquiroga.data.datasource.local.db.dao.SongDao
import com.jquiroga.data.mapper.song.SongLocalMapper
import com.jquiroga.domain.entity.Song

class SongLocalDataSource(
    private val songDao: SongDao,
    private val songLocalMapper: SongLocalMapper
) {

    suspend fun saveSongs(values: List<Song>, searchTerm: String) {
        val songRoomList = songLocalMapper.customMap(values, searchTerm)
        songDao.insert(songRoomList)
    }

}