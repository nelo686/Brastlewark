package es.mrmoustard.brastlewark.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.mrmoustard.brastlewark.R
import es.mrmoustard.brastlewark.ui.screen.common.ArrowBackIcon
import es.mrmoustard.brastlewark.ui.screen.common.Thumb
import es.mrmoustard.domain.model.Gnome
import es.mrmoustard.domain.model.getGnome

@Composable
fun DetailScreen(itemId: Int, onUpClick: () -> Unit) {
    val gnome = remember { getGnome().first { it.id == itemId } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = gnome.name) },
                navigationIcon = { ArrowBackIcon(onUpClick) }
            )
        }
    ) { padding ->
        Container(
            gnome = gnome,
            modifier = Modifier.padding(paddingValues = padding)
        )
    }
}

@Composable
fun Container(gnome: Gnome, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Thumb(
            item = gnome,
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.detail_thumb_height))
                .background(Color.Cyan)
        )
        Name(name = gnome.name)
        Overview(gnome = gnome)
        Section(header = "Professions", list = gnome.professions)
        Section(header = "Friends", list = gnome.friends)
    }
}

@Composable
private fun Name(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.h6,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(top = 25.dp)
            .fillMaxWidth()
    )
}
