package es.mrmoustard.data.source.remote

import arrow.core.Either
import es.mrmoustard.domain.error.DomainError
import es.mrmoustard.domain.model.Town

interface TownRemoteSource {
    suspend fun getPopulation(): Either<DomainError, Town>
}