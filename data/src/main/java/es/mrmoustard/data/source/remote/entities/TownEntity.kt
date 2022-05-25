package es.mrmoustard.data.source.remote.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import es.mrmoustard.domain.model.Town

@JsonClass(generateAdapter = true)
data class TownEntity(
    @Json(name = "Brastlewark")
    val population: List<GnomeEntity> = emptyList()
)

fun TownEntity.mapToDomainObject() =
    Town(population = population.mapToDomainObject())