package es.mrmoustard.domain.model

import es.mrmoustard.domain.extension.EMPTY_STRING
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GnomeTest {

    @Test
    fun `Gnome constructor should works well`() {
        val gnome = Gnome(name = "Name")

        assertEquals(0, gnome.id)
        assertEquals("Name", gnome.name)
        assertEquals(String.EMPTY_STRING, gnome.thumbnail)
        assertEquals(Gender.Unknown, gnome.gender)
        assertEquals(0, gnome.age)
        assertEquals(0.0, gnome.weight)
        assertEquals(0.0, gnome.height)
        assertEquals(String.EMPTY_STRING, gnome.hairColor)
        assertEquals(emptyList<String>(), gnome.professions)
        assertEquals(emptyList<String>(), gnome.friends)
    }

    @Test
    fun `GnomeGender should be female`() {
        val gnome = Gnome(name = "Name")
        gnome.gender = Gnome.getGnomeGender(name = gnome.name)
        assertEquals(Gender.Female, gnome.gender)
    }

    @Test
    fun `GnomeGender should be male`() {
        val gnome = Gnome(name = "Namme")
        gnome.gender = Gnome.getGnomeGender(name = gnome.name)
        assertEquals(Gender.Male, gnome.gender)
    }
}