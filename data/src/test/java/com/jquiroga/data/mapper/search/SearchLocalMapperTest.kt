package com.jquiroga.data.mapper.search

import com.jquiroga.data.datasource.local.db.entity.SearchRoom
import com.jquiroga.data.provider.SearchHistoryDataProvider
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Before
import org.junit.Test

class SearchLocalMapperTest {

    private lateinit var searchLocalMapper: SearchLocalMapper

    @Before
    fun setup() {
        searchLocalMapper = SearchLocalMapper()
    }

    @Test
    fun `verify if the mapper for the domain layer works correctly`() {
        val searchRoom = SearchHistoryDataProvider.searchRoomDummy()

        val mapped = searchLocalMapper.reverseMap(searchRoom)

        mapped shouldBeInstanceOf String::class.java
        mapped shouldBeEqualTo searchRoom.searchTerm
    }

    @Test
    fun `verify if the mapper for the data layer works correctly`() {
        val searchTerm = SearchHistoryDataProvider.searchTermDummy()

        val mapped = searchLocalMapper.map(searchTerm)

        mapped shouldBeInstanceOf SearchRoom::class.java
        mapped.searchTerm shouldBeEqualTo searchTerm
    }

}