package es.mrmoustard.brastlewark.di.domain

import es.mrmoustard.domain.usecase.GetPopulationUseCase
import org.koin.dsl.module

internal val domainModule = module {
    factory { GetPopulationUseCase(repository = get()) }
}