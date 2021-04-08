package com.jquiroga.challenge.core.failure

data class FailureModel(
    val message: String,
    val type: FailureType,
    val error: ErrorModel? = null
)