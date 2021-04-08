package com.jquiroga.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class SongEntity(
    @SerialName(FIELD_SONG_CODE)
    val code: Int,

    @SerialName(FIELD_SONG_NAME)
    val name: String? = null,

    @SerialName(FIELD_ALBUM_NAME)
    val albumName: String? = null,

    @SerialName(FIELD_BAND_NAME)
    val bandName: String? = null,

    @SerialName(FIELD_IMAGE_URL)
    val imageUrl: String? = null
) {
    companion object {
        private const val FIELD_SONG_CODE = "trackId"
        private const val FIELD_SONG_NAME = "trackName"
        private const val FIELD_ALBUM_NAME = "collectionName"
        private const val FIELD_BAND_NAME = "artistName"
        private const val FIELD_IMAGE_URL = "artworkUrl100"
    }
}