package es.mrmoustard.brastlewark.ui.common

import android.app.Activity
import android.view.View
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import java.util.*

fun Activity.showMessage(view: View, style: SnackbarStyle) {
    val snackbar = Snackbar.make(view, style.message, Snackbar.LENGTH_SHORT)
    snackbar.setBackgroundTint(style.getBackgroundColor(context = this))
    snackbar.show()
}

fun String.capitalizeIt(): String =
    replaceFirstChar {
        if (it.isLowerCase()) {
            it.titlecase(Locale.getDefault())
        } else {
            it.toString()
        }
    }

fun ImageView.load(url: String) {
    Picasso.get().load(url).into(this)
}
