package es.mrmoustard.brastlewark.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import es.mrmoustard.brastlewark.ui.theme.BrastlewarkTheme

@Composable
fun BrastlewarkComposeApp(content: @Composable () -> Unit) {
    BrastlewarkTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}