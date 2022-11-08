package es.mrmoustard.brastlewark.ui.screen.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun MainSearch(value: String, onValueChange: (String) -> Unit, onSearch: (String) -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        val focusManager = LocalFocusManager.current

        TextField(
            value = value,
            onValueChange = { onValueChange(it) },
            label = { Text(text = "Search for a Gnome ...") },
            leadingIcon = { SearchIcon() },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(onSearch = {
                focusManager.clearFocus()
                onSearch(value)
            }),
            modifier = Modifier.fillMaxWidth()
        )

        if (value.isNotEmpty()) {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .clickable { onValueChange("") }
            )
        }
    }
}

@Composable
private fun SearchIcon() {
    Icon(
        imageVector = Icons.Default.Search,
        contentDescription = null
    )
}