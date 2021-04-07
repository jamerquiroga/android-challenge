package com.jquiroga.challenge.core.failure

import com.jquiroga.challenge.core.contants.Error
import com.jquiroga.data.core.mapper.SingleMapper
import com.jquiroga.domain.exception.EmptyDataException
import com.jquiroga.domain.exception.NetworkConnectionException
import com.jquiroga.domain.exception.ServerErrorException
import com.jquiroga.domain.exception.UnauthorizedException
import java.net.SocketTimeoutException

class FailureMapper : SingleMapper<Throwable, FailureModel>() {
    override fun map(value: Throwable) = when (value) {
        is NetworkConnectionException -> FailureModel(
            message = Error.NO_CONNECTION_ERROR_MESSAGE,
            type = FailureType.NO_CONNECTION
        )

        is ServerErrorException -> FailureModel(
            message = value.message ?: Error.BAD_RESPONSE_ERROR_MESSAGE,
            type = FailureType.BAD_RESPONSE
        )

        is SocketTimeoutException -> FailureModel(
            message = Error.TIME_OUT_ERROR_MESSAGE,
            type = FailureType.TIMEOUT
        )

        is EmptyDataException -> FailureModel(
            message = Error.EMPTY_RESPONSE_ERROR_MESSAGE,
            type = FailureType.EMPTY_RESPONSE
        )

        is UnauthorizedException -> FailureModel(
            message = Error.UNAUTHORIZED_ERROR_MESSAGE,
            type = FailureType.UNAUTHORIZED
        )

        else -> FailureModel(
            message = Error.NOT_DEFINED_ERROR_MESSAGE,
            type = FailureType.NOT_DEFINED
        )
    }
}