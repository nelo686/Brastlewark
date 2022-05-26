package es.mrmoustard.brastlewark.ui

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import es.mrmoustard.brastlewark.ui.gnome.list.GnomeListAdapter
import es.mrmoustard.domain.model.Gnome

@BindingAdapter("isVisible")
fun View.setVisible(visible: Boolean?) {
    visibility = visible?.let {
        if (it) View.VISIBLE else View.GONE
    } ?: View.GONE
}

@BindingAdapter("items")
fun RecyclerView.setItems(items: LiveData<List<Gnome>>?) {
    (adapter as? GnomeListAdapter)?.let {
        it.gnomes = items?.value ?: emptyList()
    }
}