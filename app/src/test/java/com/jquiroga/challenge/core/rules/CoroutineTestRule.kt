@file:Suppress("EXPERIMENTAL_API_USAGE")

package com.jquiroga.challenge.core.rules

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class CoroutineTestRule(
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
) : TestWatcher() {

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}

fun CoroutineTestRule.runBlockingTest(block: suspend () -> Unit) =
    this.testDispatcher.runBlockingTest { block() }

fun CoroutineTestRule.pauseDispatcher() =
    this.testDispatcher.pauseDispatcher()

fun CoroutineTestRule.resumeDispatcher() =
    this.testDispatcher.resumeDispatcher()