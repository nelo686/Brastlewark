package es.mrmoustard.brastlewark.ui.gnome.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import es.mrmoustard.brastlewark.ui.common.Event
import es.mrmoustard.brastlewark.ui.common.SnackbarStyle
import es.mrmoustard.domain.model.Gnome

class GnomeListData {

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _items: MutableLiveData<List<Gnome>> = MutableLiveData(emptyList())
    val allItems: LiveData<List<Gnome>> = _items

    private val _filteredItems: MutableLiveData<List<Gnome>> = MutableLiveData(emptyList())
    val filteredItems: LiveData<List<Gnome>> = _filteredItems

    private val _message = MutableLiveData<Event<SnackbarStyle>>()
    val message: LiveData<Event<SnackbarStyle>> = _message

    private val _navigation = MutableLiveData<Event<Gnome>>()
    val navigation: LiveData<Event<Gnome>> = _navigation

    fun showLoading() {
        _isLoading.value = true
    }

    fun hideLoading() {
        _isLoading.value = false
    }

    fun showMessage(event: Event<SnackbarStyle>) {
        this._message.value = event
    }

    fun updateAllItemsList(items: List<Gnome>) {
        this._items.value = items
    }

    fun updateFilteredList(items: List<Gnome>) {
        this._filteredItems.value = items
    }

    fun navigateToDetail(event: Event<Gnome>) {
        _navigation.value = event
    }
}