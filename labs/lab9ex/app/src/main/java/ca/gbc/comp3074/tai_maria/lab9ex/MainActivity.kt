package ca.gbc.comp3074.tai_maria.lab9ex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ca.gbc.comp3074.tai_maria.lab9ex.components.ContactApp
import ca.gbc.comp3074.tai_maria.lab9ex.ui.theme.Lab9exTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab9exTheme {
                ContactApp()
            }
        }
    }
}
