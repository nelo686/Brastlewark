package es.mrmoustard.brastlewark.ui.gnome.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import es.mrmoustard.brastlewark.ui.common.Event
import es.mrmoustard.brastlewark.ui.common.SnackbarStyle
import es.mrmoustard.domain.model.Gnome

class GnomeDetailData {

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _item: MutableLiveData<Gnome> = MutableLiveData(Gnome())
    val item: LiveData<Gnome> = _item

    private val _message = MutableLiveData<Event<SnackbarStyle>>()
    val message: LiveData<Event<SnackbarStyle>> = _message

    fun showLoading() {
        _isLoading.value = true
    }

    fun hideLoading() {
        _isLoading.value = false
    }

    fun showMessage(event: Event<SnackbarStyle>) {
        this._message.value = event
    }
}