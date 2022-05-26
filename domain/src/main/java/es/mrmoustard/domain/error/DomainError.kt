package es.mrmoustard.domain.error

sealed class DomainError {
    object Network : DomainError()
    object NotFound : DomainError()
    object AccessDenied : DomainError()
    object ServiceUnavailable : DomainError()
    object Unknown : DomainError()
}
