package es.mrmoustard.data.source.remote

import arrow.core.Either
import arrow.core.Either.Left
import arrow.core.Either.Right
import es.mrmoustard.data.source.remote.api.BrastlewarkApi
import es.mrmoustard.data.source.remote.entities.TownEntity
import es.mrmoustard.data.source.remote.entities.mapToDomainObject
import es.mrmoustard.domain.error.DomainError
import es.mrmoustard.domain.error.ErrorHandler
import es.mrmoustard.domain.model.Town
import java.lang.Exception

class TownRemoteSourceImpl(
    private val api: BrastlewarkApi,
    private val errorHandler: ErrorHandler
) : TownRemoteSource {

    override suspend fun getPopulation(): Either<DomainError, Town> = try {
        val population: TownEntity = api.getPopulation()
        Right(population.mapToDomainObject())
    } catch (e: Exception) {
        Left(errorHandler.getError(throwable = e))
    }
}