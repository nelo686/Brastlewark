package es.mrmoustard.domain.model

import es.mrmoustard.domain.extension.EMPTY_STRING

data class Gnome(
    var id : Int = 0,
    var name: String = String.EMPTY_STRING,
    var thumbnail: String = String.EMPTY_STRING,
    var age: Int = 0,
    var weight: Double = 0.0,
    var height: Double = 0.0,
    var hairColor: String = String.EMPTY_STRING,
    var professions: List<String> = emptyList(),
    var friends: List<String> = emptyList()
)
