package es.mrmoustard.brastlewark.ui.gnome.detail

import androidx.lifecycle.ViewModel
import es.mrmoustard.domain.model.Gnome

class GnomeDetailViewModel(val data: GnomeDetailData) : ViewModel() {

    fun initialize(item: Gnome) {
        data.updateGnome(item = item)
        data.hideLoading()
    }
}