package com.jquiroga.challenge.feature.searcsong.mapper

import com.jquiroga.challenge.features.searchsong.mapper.SongMapper
import com.jquiroga.challenge.features.searchsong.model.SongModel
import com.jquiroga.challenge.provider.SongDataProvider
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Before
import org.junit.Test

class SongMapperTest {

    private lateinit var songMapper: SongMapper

    @Before
    fun setup() {
        songMapper = SongMapper()
    }

    @Test
    fun `check if the mapper for the presentation layer works correctly`() {
        val songDummy = SongDataProvider.songDummy()

        val mapped = songMapper.map(songDummy)

        mapped shouldBeInstanceOf SongModel::class.java
        mapped.code shouldBeEqualTo songDummy.code
        mapped.name shouldBeEqualTo songDummy.name
        mapped.albumName shouldBeEqualTo songDummy.albumName
        mapped.bandName shouldBeEqualTo songDummy.bandName
        mapped.imageUrl shouldBeEqualTo songDummy.imageUrl

    }
}