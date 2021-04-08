package com.jquiroga.domain.exception

class EmptyDataException(
    message: String? = null,
    cause: Throwable? = null
) : Exception(message ?: cause?.message, cause)