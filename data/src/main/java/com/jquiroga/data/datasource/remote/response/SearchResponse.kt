package com.jquiroga.data.datasource.remote.response

import com.jquiroga.data.entity.SongEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class SearchResponse(
    @SerialName(FIELD_RESULT)
    val results: List<SongEntity>
) {
    companion object {
        private const val FIELD_RESULT = "results"
    }
}