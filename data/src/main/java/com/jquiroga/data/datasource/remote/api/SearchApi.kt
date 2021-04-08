package com.jquiroga.data.datasource.remote.api

import com.jquiroga.data.datasource.remote.response.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("search")
    suspend fun search(
        @Query("media") mediaType: String = DEFAULT_MEDIA_TYPE,
        @Query("term") searchTerm: String,
        @Query("limit") limitPerPage: Int,
        @Query("offset") offset: Int
    ): Response<SearchResponse>

    companion object {
        private const val DEFAULT_MEDIA_TYPE = "music"
    }
}