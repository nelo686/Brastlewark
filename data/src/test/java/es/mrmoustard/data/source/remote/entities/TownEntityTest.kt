package es.mrmoustard.data.source.remote.entities

import es.mrmoustard.data.mock.emptyTownEntityMock
import es.mrmoustard.data.mock.townEntityMock
import es.mrmoustard.data.mock.townMock
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TownEntityTest {

    @Test
    fun `TownEntity constructor should works well`() {
        val entity = emptyTownEntityMock
        assertEquals(emptyList<GnomeEntity>(), entity.population)
    }

    @Test
    fun `map to domain single object test`() {
        val expected = townMock
        val actual = townEntityMock.mapToDomainObject()
        assertEquals(expected, actual)
    }
}