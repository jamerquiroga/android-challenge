package com.jquiroga.data.datasource.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jquiroga.data.datasource.local.db.dao.SearchDao
import com.jquiroga.data.datasource.local.db.dao.SongDao
import com.jquiroga.data.datasource.local.db.entity.SearchRoom
import com.jquiroga.data.datasource.local.db.entity.SongRoom

@Database(
    entities = [
        SearchRoom::class,
        SongRoom::class
    ],
    version = ChallengeAppDataBase.DATABASE_VERSION
)

abstract class ChallengeAppDataBase : RoomDatabase() {

    abstract fun searchDao(): SearchDao
    abstract fun songDao(): SongDao

    companion object {

        private const val DATABASE_NAME = "challenge.db"
        const val DATABASE_VERSION = 1

        @Volatile
        private var instance: ChallengeAppDataBase? = null

        private fun buildDatabase(context: Context) = Room
            .databaseBuilder(context, ChallengeAppDataBase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

        fun getInstance(context: Context): ChallengeAppDataBase {
            if (instance == null) {
                synchronized(ChallengeAppDataBase::class) { instance = buildDatabase(context) }
            }
            return instance!!
        }
    }
}