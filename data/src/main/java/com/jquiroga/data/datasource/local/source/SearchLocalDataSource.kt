package com.jquiroga.data.datasource.local.source

import com.jquiroga.data.datasource.local.db.dao.SearchDao
import com.jquiroga.data.datasource.local.db.entity.SearchRoom

class SearchLocalDataSource(
    private val searchDao: SearchDao
) {

    suspend fun saveSearchTerm(searchRoom: SearchRoom) {
        searchDao.insert(searchRoom)
    }

    suspend fun getAllSearch(): List<SearchRoom> {
        return searchDao.getAllSearch()
    }
}