package com.jquiroga.data.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.jquiroga.data.datasource.local.db.entity.SongRoom

@Dao
interface SongDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(values: List<SongRoom>)

}