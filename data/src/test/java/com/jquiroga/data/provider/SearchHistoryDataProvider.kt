package com.jquiroga.data.provider

import com.jquiroga.data.datasource.local.db.entity.SearchRoom

object SearchHistoryDataProvider {

    fun searchHistoryRoomDummy () = listOf(
        SearchRoom(searchTerm = "Guns n roses"),
        SearchRoom(searchTerm = "U2"),
        SearchRoom(searchTerm = "Aerosmith")
    )

    fun searchTermDummy() = "Guns n roses"
}