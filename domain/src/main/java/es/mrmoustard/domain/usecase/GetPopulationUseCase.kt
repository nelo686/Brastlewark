package es.mrmoustard.domain.usecase

import es.mrmoustard.domain.repository.TownRepository

class GetPopulationUseCase(private val repository: TownRepository) {
    suspend fun execute() = repository.getPopulation()
}