package es.mrmoustard.brastlewark.ui.gnome.list

import arrow.core.Either.Left
import arrow.core.Either.Right
import es.mrmoustard.brastlewark.ui.common.ErrorMapper
import es.mrmoustard.brastlewark.ui.gnome.mock.gnomesMock
import es.mrmoustard.brastlewark.ui.gnome.mock.townMock
import es.mrmoustard.domain.error.DomainError.DefaultError
import es.mrmoustard.domain.usecase.GetPopulationUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
internal class GnomeListViewModelTest {

    @Mock private lateinit var data: GnomeListData
    @Mock private lateinit var useCase: GetPopulationUseCase
    @Mock private lateinit var errorMapper: ErrorMapper
    private lateinit var viewModel: GnomeListViewModel

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = GnomeListViewModel(data = data, useCase = useCase, errorMapper = errorMapper)
    }

    @Test
    fun `when initialize loader is shown`() {
        runBlockingTest {
            viewModel.initialize()
            verify(data).showLoading()
        }
    }

    @Test
    fun `usecase is called with a successful result`() {
        runBlockingTest {
            whenever(useCase.execute()).thenReturn(Right(townMock))

            viewModel.initialize()
            verify(data).showLoading()
            verify(data).hideLoading()
            verify(data).updateAllItemsList(townMock.population)
            verify(data).updateFilteredList(townMock.population)
        }
    }

    @Test
    fun `usecase is called with an error result`() {
        runBlockingTest {
            val error = DefaultError(message = "Default error")
            whenever(useCase.execute()).thenReturn(Left(error))
            whenever(errorMapper.getMessage(error)).thenReturn(error.message)

            viewModel.initialize()
            verify(data).showLoading()
            verify(data).hideLoading()
            verify(data).showMessage(any())
        }
    }

    @Test
    fun `onItemClicked update a navigation event`() {
        runBlockingTest {
            val item = gnomesMock.first()
            viewModel.onItemClicked(item = item)
            verify(data).navigateToDetail(event = any())
        }
    }
}