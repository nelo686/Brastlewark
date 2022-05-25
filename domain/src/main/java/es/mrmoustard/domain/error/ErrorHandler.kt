package es.mrmoustard.domain.error

interface ErrorHandler {
    fun getError(throwable: Throwable): DomainError
}