package es.mrmoustard.domain.usecase

import arrow.core.Either.Left
import arrow.core.Either.Right
import es.mrmoustard.domain.error.DomainError.DefaultError
import es.mrmoustard.domain.extension.EMPTY_STRING
import es.mrmoustard.domain.mock.townMock
import es.mrmoustard.domain.repository.TownRepository
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

internal class GetPopulationUseCaseTest {

    @Mock
    private lateinit var repository: TownRepository

    private lateinit var useCase: GetPopulationUseCase

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetPopulationUseCase(repository = repository)
    }

    @Test
    fun `execute with success`() {
        runBlocking {
            whenever(repository.getPopulation()).thenReturn(Right(townMock))

            val result = useCase.execute()
            assertTrue(result.isRight())
        }
    }

    @Test
    fun `execute with failure`() {
        runBlocking {
            whenever(repository.getPopulation())
                .thenReturn(Left(DefaultError(message = String.EMPTY_STRING)))

            val result = useCase.execute()
            assertTrue(result.isLeft())
        }
    }
}