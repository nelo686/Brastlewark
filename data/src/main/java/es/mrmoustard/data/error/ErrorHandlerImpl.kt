package es.mrmoustard.data.error

import es.mrmoustard.domain.error.DomainError
import es.mrmoustard.domain.error.DomainError.*
import es.mrmoustard.domain.error.ErrorHandler
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection

class ErrorHandlerImpl : ErrorHandler {

    override fun getError(throwable: Throwable): DomainError {
        return when (throwable) {
            is IOException -> Network
            is HttpException -> {
                when(throwable.code()) {
                    // not found
                    HttpURLConnection.HTTP_NOT_FOUND -> NotFound

                    // access denied
                    HttpURLConnection.HTTP_FORBIDDEN -> AccessDenied

                    // unavailable service
                    HttpURLConnection.HTTP_UNAVAILABLE -> ServiceUnavailable

                    // all the others will be treated as unknown error
                    else -> Unknown
                }
            }
            else -> Unknown
        }
    }
}