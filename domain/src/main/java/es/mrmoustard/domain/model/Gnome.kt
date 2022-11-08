package es.mrmoustard.domain.model

import android.os.Parcelable
import es.mrmoustard.domain.extension.EMPTY_STRING
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gnome(
    var id: Int = 0,
    var name: String = String.EMPTY_STRING,
    var thumbnail: String = String.EMPTY_STRING,
    var gender: Gender = Gender.Unknown,
    var age: Int = 0,
    var weight: Double = 0.0,
    var height: Double = 0.0,
    var hairColor: String = String.EMPTY_STRING,
    var professions: List<String> = emptyList(),
    var friends: List<String> = emptyList()
) : Parcelable {

    companion object {
        fun getGnomeGender(name: String): Gender =
            when {
                name.length % 2 == 0 -> Gender.Female
                name.length % 2 != 0 -> Gender.Male
                else -> Gender.Unknown
            }
    }
}

fun getGnome() = (1..10).map {
    Gnome(
        id = it,
        name = "name $it",
        thumbnail = "https://loremflickr.com/320/240/dog?lock=$it",
        hairColor = "Blue",
        friends = listOf("dfgs", "dfvsv", "dfgsbgtr"),
        professions = listOf("dfgs", "dfvsv", "dfgsbgtr")
    )
}
