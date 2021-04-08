package com.jquiroga.data.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jquiroga.data.datasource.local.db.entity.SongRoom

@Dao
interface SongDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(values: List<SongRoom>)

    @Query("SELECT * FROM SongRoom WHERE code = :songCode")
    suspend fun getSongByCode(songCode: Int): SongRoom

    @Query("SELECT * FROM SongRoom WHERE search_term = :searchTerm")
    suspend fun getSongsBySearchTerm(searchTerm: String): List<SongRoom>
}