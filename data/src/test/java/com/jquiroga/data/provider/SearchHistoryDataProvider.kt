package com.jquiroga.data.provider

import com.jquiroga.data.datasource.local.db.entity.SearchRoom
import com.jquiroga.data.entity.SongEntity

object SearchHistoryDataProvider {

    fun searchHistoryRoomDummy() = listOf(
        SearchRoom(searchTerm = "Guns n roses"),
        SearchRoom(searchTerm = "U2"),
        SearchRoom(searchTerm = "Aerosmith")
    )

    fun searchRoomDummy() = SearchRoom(searchTerm = "Guns n roses")

    fun searchTermDummy() = "Guns n roses"

    fun songEntityDummy() = SongEntity(
        code = 1152324235,
        name = "November Rain",
        albumName = "Greatest Hits",
        bandName = "Guns N Roses",
        imageUrl = "https://is4-ssl.mzstatic.com/image/thumb/Music124/v4/ec/a3/5b/eca35b60-59f1-27c9-d336-3aa1699dd417/source/100x100bb.jpg"
    )
}