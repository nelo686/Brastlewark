package es.mrmoustard.brastlewark.ui.gnome.detail

import es.mrmoustard.brastlewark.InstantExecutorExtension
import es.mrmoustard.brastlewark.ui.common.DefaultSnackbarStyle
import es.mrmoustard.brastlewark.ui.common.Event
import es.mrmoustard.brastlewark.ui.gnome.mock.gnomesMock
import es.mrmoustard.domain.extension.EMPTY_STRING
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito

@ExtendWith(InstantExecutorExtension::class)
internal class GnomeDetailDataTest {

    private lateinit var data: GnomeDetailData

    @BeforeEach
    fun setUp() {
        data = Mockito.spy(GnomeDetailData())
    }

    @Test
    fun `showLoading should display loading`() {
        runBlocking {
            data.showLoading()
            data.isLoading.value?.let { assertTrue(it) }
        }
    }

    @Test
    fun `hideLoading should hide loading`() {
        data.hideLoading()
        data.isLoading.value?.let { assertFalse(it) }
    }

    @Test
    fun `showMessage should show a message`() {
        data.showMessage(event = Event(
            content = DefaultSnackbarStyle(message = String.EMPTY_STRING)
        ))
        data.message.value?.let {
            assertEquals(String.EMPTY_STRING, it.peekContent().message)
        }
    }

    @Test
    fun `updateGnome should update the items list`() {
        data.updateGnome(item = gnomesMock.first())
        data.item.value?.let {
            assertEquals(gnomesMock.first(), it)
        }
    }
}