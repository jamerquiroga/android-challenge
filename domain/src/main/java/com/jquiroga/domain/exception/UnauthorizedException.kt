package com.jquiroga.domain.exception

class UnauthorizedException(
    message: String? = null,
    cause: Throwable? = null
) : Exception(message ?: cause?.message, cause)