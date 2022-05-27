package es.mrmoustard.data.source.remote.entities

import es.mrmoustard.data.mock.gnomeEntitiesMock
import es.mrmoustard.data.mock.gnomeEntityMock
import es.mrmoustard.data.mock.gnomesMock
import es.mrmoustard.domain.extension.EMPTY_STRING
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GnomeEntityTest {

    @Test
    fun `GnomeEntity constructor should works well`() {
        val entity = gnomeEntityMock
        assertEquals(0, entity.id)
        assertEquals(String.EMPTY_STRING, entity.name)
        assertEquals(String.EMPTY_STRING, entity.thumbnail)
        assertEquals(0, entity.age)
        assertEquals(0.0, entity.height)
        assertEquals(0.0, entity.weight)
        assertEquals(String.EMPTY_STRING, entity.hairColor)
        assertEquals(emptyList<String>(), entity.professions)
        assertEquals(emptyList<String>(), entity.friends)
    }

    @Test
    fun `map to domain single object test`() {
        val expected = gnomesMock.first()
        val actual = gnomeEntitiesMock.first().mapToDomainObject()
        assertEquals(expected, actual)
    }

    @Test
    fun map_to_domain_object_list_test() {
        val expected = gnomesMock
        val actual = gnomeEntitiesMock.mapToDomainObject()
        assertEquals(expected, actual)
    }
}