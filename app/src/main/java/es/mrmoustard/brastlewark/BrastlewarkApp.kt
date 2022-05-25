package es.mrmoustard.brastlewark

import android.app.Application
import es.mrmoustard.brastlewark.di.data.dataModule
import es.mrmoustard.brastlewark.di.domain.domainModule
import es.mrmoustard.brastlewark.di.networkModule
import es.mrmoustard.brastlewark.di.presentation.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BrastlewarkApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@BrastlewarkApp)
            modules(
                networkModule,
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}