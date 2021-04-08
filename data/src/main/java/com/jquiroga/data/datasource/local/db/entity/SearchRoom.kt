package com.jquiroga.data.datasource.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class SearchRoom(
    @PrimaryKey
    @ColumnInfo(name = FIELD_SEARCH_TERM)
    val searchTerm: String
) {
    companion object {
        private const val FIELD_SEARCH_TERM = "search_term"
    }
}