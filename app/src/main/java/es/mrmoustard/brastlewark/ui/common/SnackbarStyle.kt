package es.mrmoustard.brastlewark.ui.common

import android.content.Context
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import es.mrmoustard.brastlewark.R

sealed class SnackbarStyle(
    val message: String,
    @ColorRes val color: Int
) {

    fun getBackgroundColor(context: Context) =
        ContextCompat.getColor(context, color)
}

class DefaultSnackbarStyle(message: String) : SnackbarStyle(message = message, color = R.color.magenta)
class ErrorSnackbarStyle(message: String) : SnackbarStyle(message = message, color = R.color.red)
