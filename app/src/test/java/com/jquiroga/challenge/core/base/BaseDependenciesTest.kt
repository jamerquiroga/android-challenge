package com.jquiroga.challenge.core.base

import org.junit.Before
import org.koin.test.AutoCloseKoinTest

abstract class BaseDependenciesTest : AutoCloseKoinTest(){

    abstract fun setupInjectTestModules()

    @Before
    fun setup(){
        setupInjectTestModules()
    }

}