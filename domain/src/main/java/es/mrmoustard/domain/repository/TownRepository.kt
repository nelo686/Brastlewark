package es.mrmoustard.domain.repository

import arrow.core.Either
import es.mrmoustard.domain.error.DomainError
import es.mrmoustard.domain.model.Town

interface TownRepository {
    suspend fun getPopulation(): Either<DomainError, Town>
}