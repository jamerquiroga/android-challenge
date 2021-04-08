package com.jquiroga.data.repository

import com.jquiroga.data.datasource.local.source.SearchLocalDataSource
import com.jquiroga.data.mapper.search.SearchLocalMapper
import com.jquiroga.domain.repository.SearchRepository

class SearchDataRepository(
    private val searchLocalDataSource: SearchLocalDataSource,
    private val searchLocalMapper: SearchLocalMapper
) : SearchRepository {

    override suspend fun saveSearchTerm(searchTerm: String) {
        searchLocalDataSource.saveSearchTerm(searchLocalMapper.map(searchTerm))
    }

    override suspend fun getAllSearchTerms(): List<String> {
        return searchLocalMapper.reverseMap(searchLocalDataSource.getAllSearch())
    }
}