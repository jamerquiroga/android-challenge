package com.jquiroga.data.dao

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.jquiroga.data.datasource.local.db.ChallengeAppDataBase
import org.junit.After
import org.junit.Before


open class BaseDao {

    protected lateinit var database: ChallengeAppDataBase

    @Before
    open fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            ChallengeAppDataBase::class.java
        ).allowMainThreadQueries().build()
    }

    @After
    open fun closeDb() {
        database.close()
    }

}