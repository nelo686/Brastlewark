package es.mrmoustard.brastlewark.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.mrmoustard.brastlewark.ui.theme.DarkGray
import es.mrmoustard.domain.model.Gnome


@Composable
fun Overview(gnome: Gnome) {
    Column(
        modifier = Modifier
            .background(DarkGray)
            .fillMaxWidth()
            .padding(start = 10.dp, top = 15.dp, bottom = 15.dp)
    ) {
        OverviewItem("${gnome.gender} gender")
        OverviewItem("Age ${gnome.age} years old")
        OverviewItem("Height ${gnome.height} inches")
        OverviewItem("Weight ${gnome.weight} pounds")
        OverviewItem("${gnome.hairColor} hair color")
    }
}

@Composable
private fun OverviewItem(data: String) {
    Text(
        text = data,
        fontSize = 15.sp,
        color = Color.White
    )
}