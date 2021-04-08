package com.jquiroga.data.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jquiroga.data.datasource.local.db.entity.SearchRoom

@Dao
interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(value: SearchRoom)

    @Query("SELECT * FROM SearchRoom")
    suspend fun getAllSearch(): List<SearchRoom>
}