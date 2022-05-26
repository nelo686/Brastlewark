package es.mrmoustard.brastlewark.di.presentation

import es.mrmoustard.brastlewark.ui.common.ErrorMapper
import es.mrmoustard.brastlewark.ui.gnome.detail.GnomeDetailData
import es.mrmoustard.brastlewark.ui.gnome.detail.GnomeDetailViewModel
import es.mrmoustard.brastlewark.ui.gnome.list.GnomeListData
import es.mrmoustard.brastlewark.ui.gnome.list.GnomeListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val presentationModule = module {

    factory { ErrorMapper(context = get()) }

    viewModel {
        GnomeListViewModel(
            data = GnomeListData(),
            useCase = get(),
            errorMapper = get()
        )
    }

    viewModel {
        GnomeDetailViewModel(
            data = GnomeDetailData()
        )
    }
}