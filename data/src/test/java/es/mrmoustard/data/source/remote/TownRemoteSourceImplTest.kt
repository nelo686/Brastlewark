package es.mrmoustard.data.source.remote

import es.mrmoustard.data.mock.townEntityMock
import es.mrmoustard.data.source.remote.api.BrastlewarkApi
import es.mrmoustard.domain.error.ErrorHandler
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever
import java.lang.Exception

internal class TownRemoteSourceImplTest {

    @Mock private lateinit var api: BrastlewarkApi
    @Mock private lateinit var errorHandler: ErrorHandler

    private lateinit var remote: TownRemoteSource

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        remote = TownRemoteSourceImpl(api = api, errorHandler = errorHandler)
    }

    @Test
    fun `getPopulation should retrieve a gnome list`() {
        runBlocking {
            whenever(api.getPopulation()).thenReturn(townEntityMock)
            val response = remote.getPopulation()
            assertTrue(response.isRight())
        }
    }

    @Test
    fun `getPopulation should retrieve an error`() {
        runBlocking {
            whenever(api.getPopulation()).thenAnswer { throw Exception() }
            val response = remote.getPopulation()
            assertTrue(response.isLeft())
        }
    }
}