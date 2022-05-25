package es.mrmoustard.domain.model

import java.util.*

sealed class HairColor(val color: String) {

    companion object {
        private const val UNKNOWN_COLOR = "unknown"
        private const val PINK_COLOR = "pink"
        private const val GREEN_COLOR = "green"
        private const val RED_COLOR = "red"
        private const val BLACK_COLOR = "black"
        private const val GRAY_COLOR = "gray"
    }

    object UnknownHairColor: HairColor(color = UNKNOWN_COLOR)
    object PinkHairColor : HairColor(color = PINK_COLOR)
    object GreenHairColor : HairColor(color = GREEN_COLOR)
    object RedHairColor : HairColor(color = RED_COLOR)
    object BlackHairColor : HairColor(color = BLACK_COLOR)
    object GrayHairColor : HairColor(color = GRAY_COLOR)

    fun getHairColor(color: String): HairColor =
        when (color.lowercase(Locale.getDefault())) {
            PINK_COLOR -> PinkHairColor
            GREEN_COLOR -> GreenHairColor
            RED_COLOR -> RedHairColor
            BLACK_COLOR -> BlackHairColor
            GRAY_COLOR -> GrayHairColor
            else -> UnknownHairColor
        }
}
