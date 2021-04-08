package com.jquiroga.challenge.dependencies

import com.jquiroga.challenge.core.base.BaseDependenciesTest
import com.jquiroga.challenge.dependencies.di.injectTestModules
import com.jquiroga.data.datasource.remote.api.SearchApi
import org.amshove.kluent.shouldNotBeNull
import org.junit.Test
import org.koin.test.get

class ApiDependenciesTest: BaseDependenciesTest() {

    override fun setupInjectTestModules() = injectTestModules()

    @Test
    fun `solving dependencies for SearchApi`() {
        get<SearchApi>().shouldNotBeNull()
    }

}