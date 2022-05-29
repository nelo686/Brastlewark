package es.mrmoustard.brastlewark.ui.common

import android.content.Context
import es.mrmoustard.brastlewark.R
import es.mrmoustard.domain.error.DomainError
import es.mrmoustard.domain.error.DomainError.*

class ErrorMapper(private val context: Context) {

    fun getMessage(error: DomainError): String =
        when (error) {
            is DefaultError -> context.getString(R.string.default_error)
            AccessDenied -> context.getString(R.string.access_denied_error)
            Network -> context.getString(R.string.network_error)
            NotFound -> context.getString(R.string.not_found_error)
            ServiceUnavailable -> context.getString(R.string.unavailable_service_error)
            Unknown -> context.getString(R.string.something_happen_error)
        }
}