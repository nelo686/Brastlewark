package es.mrmoustard.brastlewark.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Section(header: String, list: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 25.dp, end = 10.dp)
    ) {
        Header(text = header)
        Divider(color = Color.Gray, thickness = 0.5.dp)
        Text(
            text = buildList(list = list),
            modifier = Modifier.padding(top = 5.dp, bottom = 10.dp)
        )
    }
}

@Composable
private fun Header(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h6,
        color = Color.DarkGray,
        fontSize = 24.sp,
        textAlign = TextAlign.End,
        modifier = Modifier.fillMaxWidth()
    )
}

fun buildList(list: List<String>): String =
    "[${list.joinToString(separator = ", ")}]"