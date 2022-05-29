package es.mrmoustard.domain.model

import es.mrmoustard.domain.model.Gender.*
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class GenderTest {

    @Test
    fun `state gender to male`() {
        assertThat(
            generateMaleGender(),
            instanceOf(Male::class.java)
        )
    }

    @Test
    fun `state gender to female`() {
        assertThat(
            generateFemaleGender(),
            instanceOf(Female::class.java)
        )
    }

    @Test
    fun `state gender to Unknown`() {
        assertThat(
            generateUnknownGender(),
            instanceOf(Unknown::class.java)
        )
    }

    private fun generateMaleGender() = Male

    private fun generateFemaleGender() = Female

    private fun generateUnknownGender() = Unknown
}