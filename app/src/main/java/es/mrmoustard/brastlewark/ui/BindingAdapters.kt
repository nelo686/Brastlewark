package es.mrmoustard.brastlewark.ui

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import es.mrmoustard.brastlewark.R
import es.mrmoustard.brastlewark.ui.common.load
import es.mrmoustard.brastlewark.ui.gnome.list.GnomeListAdapter
import es.mrmoustard.domain.model.Gender
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

@BindingAdapter("imageUrl")
fun AppCompatImageView.loadImage(url: String?) {
    url?.let { load(url = it) }
}

@BindingAdapter("gnomeGender")
fun TextView.setGnomeGender(gender: Gender) {
    text = when(gender.type) {
        Gender.Male.type -> "${resources.getString(R.string.gnome_detail_male_gender)} ${resources.getString(R.string.gnome_detail_gender)}"
        Gender.Female.type -> "${resources.getString(R.string.gnome_detail_female_gender)} ${resources.getString(R.string.gnome_detail_gender)}"
        else -> "${resources.getString(R.string.gnome_detail_unknown_gender)} ${resources.getString(R.string.gnome_detail_gender)}"
    }
}