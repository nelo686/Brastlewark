package es.mrmoustard.brastlewark.ui.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import es.mrmoustard.domain.model.Gnome

@Composable
fun MainScreen(onGnomeClick: (Gnome) -> Unit) {
    Scaffold(
        topBar = { MainAppBar() }
    ) { padding ->
        var criteria by rememberSaveable { mutableStateOf("") }

        Column {
            MainSearch(
                value = criteria,
                onValueChange = { criteria = it },
                onSearch = { /*TODO*/ }
            )
            GnomeList(
                onClick = onGnomeClick,
                modifier = Modifier.padding(padding)
            )
        }
    }
}