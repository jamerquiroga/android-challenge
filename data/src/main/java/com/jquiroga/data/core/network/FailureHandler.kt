package com.jquiroga.data.core.network

import com.jquiroga.domain.exception.NetworkConnectionException
import com.jquiroga.domain.exception.ServerErrorException
import com.jquiroga.domain.exception.UnauthorizedException
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

internal class FailureHandler {

    fun build(e: Throwable): Throwable {
        return when (e) {
            is HttpException -> buildExceptionByType(e)
            is SocketTimeoutException -> e
            is IOException -> NetworkConnectionException(
                cause = e
            )
            else -> ServerErrorException(cause = e)
        }
    }

    private fun buildExceptionByType(e: HttpException): Exception {
        return when (e.code()) {
            UNAUTHORIZED_CODE,
            FORBIDDEN_CODE -> UnauthorizedException(
                cause = e
            )
            else -> ServerErrorException(cause = e)
        }
    }

    companion object {
        const val UNAUTHORIZED_CODE = 401
        const val FORBIDDEN_CODE = 403
    }
}