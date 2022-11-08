package es.mrmoustard.brastlewark.ui.screen.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import es.mrmoustard.brastlewark.R
import es.mrmoustard.brastlewark.ui.screen.common.Thumb
import es.mrmoustard.brastlewark.ui.theme.BrastlewarkTheme
import es.mrmoustard.domain.model.Gnome
import es.mrmoustard.domain.model.getGnome

@Composable
fun GnomeItem(item: Gnome, onClick: () -> Unit) {
    BrastlewarkTheme {
        Card(
            modifier = Modifier.clickable(onClick = onClick),
            elevation = dimensionResource(id = R.dimen.card_elevation),
            border = BorderStroke(dimensionResource(id = R.dimen.card_border_stroke), Color.LightGray)
        ) {
            Column {
                Thumb(
                    item = item,
                    modifier = Modifier.height(
                        dimensionResource(id = R.dimen.cell_thumb_height)
                    )
                )
                Title(item = item)
            }
        }
    }
}

@Composable
private fun Title(item: Gnome) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        Text(
            text = item.name,
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun GnomeList(onClick: (Gnome) -> Unit, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_min_width)),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_xsmall)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_xsmall)),
        modifier = modifier
    ) {
        items(getGnome()) { item ->
            GnomeItem(item = item) { onClick(item) }
        }
    }
}