package com.jquiroga.challenge.dependencies

import com.jquiroga.challenge.core.base.BaseDependenciesTest
import com.jquiroga.challenge.dependencies.di.injectTestModules
import com.jquiroga.domain.usecase.GetSearchHistoryUseCase
import com.jquiroga.domain.usecase.SaveSearchTermUseCase
import com.jquiroga.domain.usecase.SearchSongsByTermUseCase
import org.amshove.kluent.shouldNotBeNull
import org.junit.Test
import org.koin.test.get

class UseCaseDependenciesTest: BaseDependenciesTest() {

    override fun setupInjectTestModules() = injectTestModules()

    @Test
    fun `solving dependencies for SearchSongsByTermUseCase`() {
        get<SearchSongsByTermUseCase>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for SaveSearchTermUseCase`() {
        get<SaveSearchTermUseCase>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for GetSearchHistoryUseCase`() {
        get<GetSearchHistoryUseCase>().shouldNotBeNull()
    }
}