package com.jquiroga.data.mapper.song

import com.jquiroga.data.provider.SearchHistoryDataProvider
import com.jquiroga.domain.entity.Song
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Before
import org.junit.Test

class SongRemoteMapperTest {

    private lateinit var songRemoteMapper: SongRemoteMapper

    @Before
    fun setup() {
        songRemoteMapper = SongRemoteMapper()
    }

    @Test
    fun `verify if the mapper for the domain layer works correctly`() {
        val songEntity = SearchHistoryDataProvider.songEntityDummy()

        val mapped = songRemoteMapper.map(songEntity)

        mapped shouldBeInstanceOf Song::class.java
        mapped.code shouldBeEqualTo songEntity.code
        mapped.name shouldBeEqualTo songEntity.name
        mapped.albumName shouldBeEqualTo songEntity.albumName
        mapped.bandName shouldBeEqualTo songEntity.bandName
        mapped.imageUrl shouldBeEqualTo songEntity.imageUrl
    }
}