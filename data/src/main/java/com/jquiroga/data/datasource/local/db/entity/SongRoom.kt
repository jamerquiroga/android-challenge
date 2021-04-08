package com.jquiroga.data.datasource.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class SongRoom(
    @PrimaryKey
    @ColumnInfo(name = FIELD_CODE)
    val code: Int,

    @ColumnInfo(name = FIELD_NAME)
    val name: String,

    @ColumnInfo(name = FIELD_ALBUM_NAME)
    val albumName: String,

    @ColumnInfo(name = FIELD_BAND_NAME)
    val bandName: String,

    @ColumnInfo(name = FIELD_IMAGE_URL)
    val imageUrl: String,

    @ColumnInfo(name = FIELD_SEARCH_TERM)
    val searchTerm: String
) {
    companion object {
        private const val FIELD_CODE = "code"
        private const val FIELD_NAME = "name"
        private const val FIELD_ALBUM_NAME = "album_name"
        private const val FIELD_BAND_NAME = "band_name"
        private const val FIELD_IMAGE_URL = "image_url"
        private const val FIELD_SEARCH_TERM = "search_term"
    }
}