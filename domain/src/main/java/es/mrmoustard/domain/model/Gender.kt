package es.mrmoustard.domain.model

sealed class Gender(val type: Int) {

    companion object {
        private const val MALE_TYPE = 1
        private const val FEMALE_TYPE = 2
        private const val QUEER_TYPE = 3
    }

    object Male: Gender(type = MALE_TYPE)
    object Female: Gender(type = FEMALE_TYPE)
    object Queer: Gender(type = QUEER_TYPE)
}
