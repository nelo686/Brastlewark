package es.mrmoustard.brastlewark.ui.gnome.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import es.mrmoustard.brastlewark.ui.common.Event
import es.mrmoustard.brastlewark.ui.common.SnackbarStyle
import es.mrmoustard.domain.model.Gnome

class GnomeListData {

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _allItems: MutableLiveData<List<Gnome>> = MutableLiveData(emptyList())
    val allItems: LiveData<List<Gnome>> = _allItems

    private val _filteredItems: MutableLiveData<List<Gnome>> = MutableLiveData(emptyList())
    val filteredItems: LiveData<List<Gnome>> = _filteredItems

    private val _message = MutableLiveData<Event<SnackbarStyle>>()
    val message: LiveData<Event<SnackbarStyle>> = _message

    private val _navigation = MutableLiveData<Event<Gnome>>()
    val navigation: LiveData<Event<Gnome>> = _navigation

    fun showLoading() {
        _isLoading.postValue(true)
    }

    fun hideLoading() {
        _isLoading.postValue(false)
    }

    fun showMessage(event: Event<SnackbarStyle>) {
        this._message.postValue(event)
    }

    fun updateAllItemsList(items: List<Gnome>) {
        this._allItems.postValue(items)
    }

    fun updateFilteredList(items: List<Gnome>) {
        this._filteredItems.postValue(items)
    }

    fun addFilteredItem(item: Gnome) {
        _filteredItems.value?.toMutableList().let {
            it?.add(item)
            _filteredItems.postValue(it)
        }
    }

    fun navigateToDetail(event: Event<Gnome>) {
        _navigation.postValue(event)
    }
}