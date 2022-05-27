package es.mrmoustard.data.mock

import es.mrmoustard.data.source.remote.entities.GnomeEntity
import es.mrmoustard.data.source.remote.entities.TownEntity
import es.mrmoustard.domain.extension.EMPTY_STRING
import es.mrmoustard.domain.model.Gender
import es.mrmoustard.domain.model.Gnome
import es.mrmoustard.domain.model.Town

internal val gnomeEntityMock = GnomeEntity(
    name = String.EMPTY_STRING,
    thumbnail = String.EMPTY_STRING,
    hairColor = String.EMPTY_STRING,
)

internal val gnomeEntitiesMock = listOf(
    GnomeEntity(id = 0, name = "name", thumbnail = String.EMPTY_STRING, age = 100, weight = 30.0, height = 75.0, hairColor = String.EMPTY_STRING),
    GnomeEntity(id = 1, name = "nAme", thumbnail = String.EMPTY_STRING, age = 110, weight = 31.0, height = 76.0, hairColor = String.EMPTY_STRING),
    GnomeEntity(id = 2, name = "naMe", thumbnail = String.EMPTY_STRING, age = 120, weight = 32.0, height = 77.0, hairColor = String.EMPTY_STRING),
    GnomeEntity(id = 3, name = "namE", thumbnail = String.EMPTY_STRING, age = 130, weight = 33.0, height = 78.0, hairColor = String.EMPTY_STRING),
    GnomeEntity(id = 4, name = "Name", thumbnail = String.EMPTY_STRING, age = 140, weight = 34.0, height = 79.0, hairColor = String.EMPTY_STRING),
)

internal val gnomesMock = listOf(
    Gnome(id = 0, name = "name", thumbnail = String.EMPTY_STRING, gender = Gender.Female, age = 100, weight = 30.0, height = 75.0, hairColor = String.EMPTY_STRING),
    Gnome(id = 1, name = "nAme", thumbnail = String.EMPTY_STRING, gender = Gender.Female, age = 110, weight = 31.0, height = 76.0, hairColor = String.EMPTY_STRING),
    Gnome(id = 2, name = "naMe", thumbnail = String.EMPTY_STRING, gender = Gender.Female, age = 120, weight = 32.0, height = 77.0, hairColor = String.EMPTY_STRING),
    Gnome(id = 3, name = "namE", thumbnail = String.EMPTY_STRING, gender = Gender.Female, age = 130, weight = 33.0, height = 78.0, hairColor = String.EMPTY_STRING),
    Gnome(id = 4, name = "Name", thumbnail = String.EMPTY_STRING, gender = Gender.Female, age = 140, weight = 34.0, height = 79.0, hairColor = String.EMPTY_STRING),
)

internal val emptyTownEntityMock = TownEntity()
internal val townEntityMock = TownEntity(population = gnomeEntitiesMock)
internal val townMock = Town(population = gnomesMock)