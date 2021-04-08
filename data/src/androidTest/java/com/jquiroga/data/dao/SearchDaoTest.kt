package com.jquiroga.data.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jquiroga.data.datasource.local.db.entity.SearchRoom
import kotlinx.coroutines.runBlocking
import junit.framework.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SearchDaoTest : BaseDao() {

    private val searchDao by lazy { database.searchDao() }

    @Test
    fun verify_that_the_data_is_inserted_and_read_in_the_database() = runBlocking {

        val searchRoom = SearchRoom(searchTerm = "Guns n roses")

        searchDao.insert(searchRoom)

        val result = searchDao.getAllSearch()

        assertEquals(result.size, 1)

    }

}