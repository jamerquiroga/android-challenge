package com.jquiroga.challenge.dependencies

import com.jquiroga.challenge.core.base.BaseDependenciesTest
import com.jquiroga.challenge.dependencies.di.injectTestModules
import com.jquiroga.challenge.features.searchhistory.view.SearchHistoryViewModel
import com.jquiroga.challenge.features.searchsong.view.SearchSongViewModel
import org.amshove.kluent.shouldNotBeNull
import org.junit.Test
import org.koin.test.get

class ViewModelDependenciesTest: BaseDependenciesTest() {

    override fun setupInjectTestModules() = injectTestModules()

    @Test
    fun `solving dependencies for SearchSongViewModel`() {
        get<SearchSongViewModel>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for SearchHistoryViewModel`() {
        get<SearchHistoryViewModel>().shouldNotBeNull()
    }

}