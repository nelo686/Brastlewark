package es.mrmoustard.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class Gender(val type: Int) : Parcelable {

    companion object {
        private const val MALE_TYPE = 1
        private const val FEMALE_TYPE = 2
        private const val UNKNOWN_TYPE = 3
    }

    object Male: Gender(type = MALE_TYPE)
    object Female: Gender(type = FEMALE_TYPE)
    object Unknown: Gender(type = UNKNOWN_TYPE)
}
