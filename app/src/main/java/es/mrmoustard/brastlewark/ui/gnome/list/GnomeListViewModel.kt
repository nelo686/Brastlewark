package es.mrmoustard.brastlewark.ui.gnome.list

import android.text.Editable
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
import java.util.*

class GnomeListViewModel(
    val data: GnomeListData,
    private val useCase: GetPopulationUseCase,
    private val errorMapper: ErrorMapper
) : ViewModel() {

    companion object {
        private const val DELAY: Long = 600
    }

    private var timerFilterGnomeList: Timer? = null

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
        data.updateAllItemsList(items = town.population)
        data.updateFilteredList(items = town.population)
    }

    fun onItemClicked(item: Gnome) {
        data.navigateToDetail(Event(item))
    }

    fun cancelTimer() {
        timerFilterGnomeList?.cancel()
    }

    fun filter(editable: Editable?) {
        if (!editable.isNullOrBlank()) {
            data.updateFilteredList(items = emptyList())
            val searchCriteria = editable.toString()
            timerFilterGnomeList = Timer("FilterGnomeList", false)
            timerFilterGnomeList?.schedule(object : TimerTask() {
                override fun run() {
                    if (!data.allItems.value.isNullOrEmpty()) {
                        data.allItems.value?.forEach { gnome ->
                            if (gnome.name.contains(searchCriteria, true)) {
                                data.addFilteredItem(item = gnome)
                            }
                        }
                    }
                }
            }, DELAY)
        } else {
            // filtrado vacio
            data.updateFilteredList(data.allItems.value!!)
        }
    }
}