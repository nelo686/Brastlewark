package es.mrmoustard.data.error

import es.mrmoustard.domain.error.DomainError
import es.mrmoustard.domain.error.DomainError.*
import es.mrmoustard.domain.error.ErrorHandler
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection

class ErrorHandlerImpl : ErrorHandler {

    override fun getError(throwable: Throwable): DomainError =
        when (throwable) {
            is IOException -> Network
            is HttpException -> {
                when(throwable.code()) {
                    HttpURLConnection.HTTP_NOT_FOUND -> NotFound
                    HttpURLConnection.HTTP_FORBIDDEN -> AccessDenied
                    HttpURLConnection.HTTP_UNAVAILABLE -> ServiceUnavailable
                    else -> Unknown
                }
            }
            else -> Unknown
        }
}