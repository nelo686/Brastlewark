package es.mrmoustard.data.source.remote.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import es.mrmoustard.domain.model.Gnome

@JsonClass(generateAdapter = true)
data class GnomeEntity(
    @Json(name = "id")
    var id : Int = 0,
    @Json(name = "name")
    var name: String? = null,
    @Json(name = "thumbnail")
    var thumbnail: String? = null,
    @Json(name = "age")
    var age: Int = 0,
    @Json(name = "weight")
    var weight: Double = 0.0,
    @Json(name = "height")
    var height: Double = 0.0,
    @Json(name = "hair_color")
    var hairColor: String? = null,
    @Json(name = "professions")
    var professions: List<String> = emptyList(),
    @Json(name = "friends")
    var friends: List<String> = emptyList()
)

fun GnomeEntity.mapToDomainObject() =
    Gnome(
        id = id,
        name = name.orEmpty(),
        thumbnail = thumbnail.orEmpty(),
        age = age,
        weight = weight,
        height = height,
        hairColor = hairColor.orEmpty(),
        professions = professions,
        friends = friends
    )

fun List<GnomeEntity>.mapToDomainObject(): List<Gnome> {
    val list: MutableList<Gnome> = mutableListOf()
    this.forEach { list.add(element = it.mapToDomainObject()) }
    return list
}
