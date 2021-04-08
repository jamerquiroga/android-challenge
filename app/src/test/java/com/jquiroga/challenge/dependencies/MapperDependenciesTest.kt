package com.jquiroga.challenge.dependencies

import com.jquiroga.challenge.core.base.BaseDependenciesTest
import com.jquiroga.challenge.dependencies.di.injectTestModules
import com.jquiroga.data.mapper.search.SearchLocalMapper
import com.jquiroga.data.mapper.song.SongLocalMapper
import com.jquiroga.data.mapper.song.SongRemoteMapper
import org.amshove.kluent.shouldNotBeNull
import org.junit.Test
import org.koin.test.get

class MapperDependenciesTest: BaseDependenciesTest() {

    override fun setupInjectTestModules() = injectTestModules()

    @Test
    fun `solving dependencies for SearchLocalMapper`() {
        get<SearchLocalMapper>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for SongLocalMapper`() {
        get<SongLocalMapper>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for SongRemoteMapper`() {
        get<SongRemoteMapper>().shouldNotBeNull()
    }
}