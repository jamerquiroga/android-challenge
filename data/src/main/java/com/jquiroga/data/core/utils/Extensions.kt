package com.jquiroga.data.core.utils

import com.jquiroga.data.core.network.FailureHandler

internal fun Throwable.buildFailure() = FailureHandler().build(this)