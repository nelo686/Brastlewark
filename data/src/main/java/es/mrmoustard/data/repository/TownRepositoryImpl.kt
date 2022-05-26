package es.mrmoustard.data.repository

import arrow.core.Either
import es.mrmoustard.data.source.remote.TownRemoteSource
import es.mrmoustard.domain.error.DomainError
import es.mrmoustard.domain.model.Town
import es.mrmoustard.domain.repository.TownRepository

class TownRepositoryImpl(
    private val remoteSource: TownRemoteSource
): TownRepository {

    override suspend fun getPopulation(): Either<DomainError, Town> =
        remoteSource.getPopulation()
}