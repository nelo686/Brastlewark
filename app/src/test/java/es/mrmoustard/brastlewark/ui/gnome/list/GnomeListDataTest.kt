package es.mrmoustard.brastlewark.ui.gnome.list

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
import org.mockito.Mockito.spy

@ExtendWith(InstantExecutorExtension::class)
internal class GnomeListDataTest {

    private lateinit var data: GnomeListData

    @BeforeEach
    fun setUp() {
        data = spy(GnomeListData())
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
    fun `updateAllItemsList should update the items list`() {
        data.updateAllItemsList(items = gnomesMock)
        data.allItems.value?.let {
            assertEquals(gnomesMock.first(), it.first())
            assertEquals(gnomesMock.size, it.size)
        }
    }

    @Test
    fun `updateFilteredList should update the filtered items list`() {
        data.updateFilteredList(items = gnomesMock)
        data.filteredItems.value?.let {
            assertEquals(gnomesMock.first(), it.first())
            assertEquals(gnomesMock.size, it.size)
        }
    }

    @Test
    fun `addFilteredItem should add an item to the filtered items list`() {
        data.updateFilteredList(items = emptyList())
        data.addFilteredItem(item = gnomesMock.first())
        data.filteredItems.value?.let {
            assertEquals(gnomesMock.first(), it.first())
            assertEquals(1, it.size)
        }
    }
}