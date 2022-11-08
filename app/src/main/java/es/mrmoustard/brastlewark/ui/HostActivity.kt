package es.mrmoustard.brastlewark.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import es.mrmoustard.brastlewark.ui.navigation.Navigation

class HostActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrastlewarkComposeApp {
                Navigation()
            }
        }
    }
}