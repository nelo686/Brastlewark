package es.mrmoustard.brastlewark.ui.screen.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import es.mrmoustard.domain.model.Gnome

@Composable
fun Thumb(
    item: Gnome,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = item.thumbnail,
        contentDescription = null,
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}