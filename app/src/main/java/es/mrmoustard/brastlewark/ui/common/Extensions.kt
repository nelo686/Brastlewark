package es.mrmoustard.brastlewark.ui.common

import android.app.Activity
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar
import es.mrmoustard.brastlewark.R

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun Activity.showMessage(view: View, style: SnackbarStyle) {
    val snackbar = Snackbar.make(view, style.message, Snackbar.LENGTH_SHORT)
    snackbar.setBackgroundTint(style.getBackgroundColor(context = this))
    snackbar.show()
}

fun ImageView.load(url: String) {
    val glideUrl = GlideUrl(
        url,
        LazyHeaders.Builder().addHeader(
            "User-Agent",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit / 537.36(KHTML, like Gecko) Chrome  47.0.2526.106 Safari / 537.36"
        ).build()
    )

    Glide
        .with(this.context)
        .load(glideUrl)
        .placeholder(R.drawable.no_image_placeholder)
        .error(R.drawable.no_image_available)
        .apply(RequestOptions().timeout(5000))
        .into(this)
}
