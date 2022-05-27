package es.mrmoustard.domain.model

import es.mrmoustard.domain.mock.gnomesMock
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TownTest {

    @Test
    fun `Town constructor should works well`() {
        val town = Town(population = gnomesMock)

        assertEquals(gnomesMock.first().id, town.population.first().id)
        assertEquals(gnomesMock.first().name, town.population.first().name)
        assertEquals(gnomesMock.first().thumbnail, town.population.first().thumbnail)
        assertEquals(gnomesMock.first().gender, town.population.first().gender)
        assertEquals(gnomesMock.first().age, town.population.first().age)
        assertEquals(gnomesMock.first().weight, town.population.first().weight)
        assertEquals(gnomesMock.first().height, town.population.first().height)
        assertEquals(gnomesMock.first().hairColor, town.population.first().hairColor)
        assertEquals(gnomesMock.first().professions, town.population.first().professions)
        assertEquals(gnomesMock.first().friends, town.population.first().friends)
    }
}