package com.jquiroga.challenge.dependencies

import com.jquiroga.challenge.core.base.BaseDependenciesTest
import com.jquiroga.challenge.dependencies.di.injectTestModules
import com.jquiroga.domain.repository.SearchRepository
import com.jquiroga.domain.repository.SongRepository
import org.amshove.kluent.shouldNotBeNull
import org.junit.Test
import org.koin.test.get

class RepositoryDependenciesTest: BaseDependenciesTest() {

    override fun setupInjectTestModules() = injectTestModules()

    @Test
    fun `solving dependencies for SearchRepository`() {
        get<SearchRepository>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for SongRepository`() {
        get<SongRepository>().shouldNotBeNull()
    }
}