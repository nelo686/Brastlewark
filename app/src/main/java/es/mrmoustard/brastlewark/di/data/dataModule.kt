package es.mrmoustard.brastlewark.di.data

import es.mrmoustard.data.error.ErrorHandlerImpl
import es.mrmoustard.data.source.remote.TownRemoteSource
import es.mrmoustard.data.source.remote.TownRemoteSourceImpl
import es.mrmoustard.data.source.remote.api.BrastlewarkApi
import es.mrmoustard.domain.error.ErrorHandler
import org.koin.dsl.module
import retrofit2.Retrofit

internal val dataModule = module {

    single<BrastlewarkApi> { get<Retrofit>().create(BrastlewarkApi::class.java) }

    factory<ErrorHandler> { ErrorHandlerImpl() }

    single<TownRemoteSource> {
        TownRemoteSourceImpl(
            api = get(),
            errorHandler = get()
        )
    }
}
