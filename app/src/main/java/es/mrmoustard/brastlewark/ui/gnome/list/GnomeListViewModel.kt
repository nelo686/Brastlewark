package es.mrmoustard.brastlewark.ui.gnome.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.mrmoustard.brastlewark.ui.common.ErrorMapper
import es.mrmoustard.brastlewark.ui.common.ErrorSnackbarStyle
import es.mrmoustard.brastlewark.ui.common.Event
import es.mrmoustard.domain.error.DomainError
import es.mrmoustard.domain.model.Gnome
import es.mrmoustard.domain.model.Town
import es.mrmoustard.domain.usecase.GetPopulationUseCase
import kotlinx.coroutines.launch

class GnomeListViewModel(
    val data: GnomeListData,
    private val useCase: GetPopulationUseCase,
    private val errorMapper: ErrorMapper
) : ViewModel() {

    fun initialize() {
        viewModelScope.launch {
            data.showLoading()
            useCase.execute().fold(
                ifLeft = ::handleError,
                ifRight = ::handleGetPopulationSuccess
            )
        }
    }

    private fun handleError(error: DomainError) {
        data.hideLoading()
        data.showMessage(
            event = Event(
                content = ErrorSnackbarStyle(
                    message = errorMapper.getMessage(error = error)
                )
            )
        )
    }

    private fun handleGetPopulationSuccess(town: Town) {
        data.hideLoading()
        var a=0
    }

    fun onItemClicked(item: Gnome) {
        data.navigateToDetail(Event(item))
    }
}