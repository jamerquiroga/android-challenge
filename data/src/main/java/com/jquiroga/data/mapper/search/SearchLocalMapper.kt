package com.jquiroga.data.mapper.search

import com.jquiroga.data.core.mapper.Mapper
import com.jquiroga.data.datasource.local.db.entity.SearchRoom

class SearchLocalMapper : Mapper<String, SearchRoom>() {

    override fun reverseMap(value: SearchRoom) = value.searchTerm

    override fun map(value: String) = SearchRoom(searchTerm = value)

}