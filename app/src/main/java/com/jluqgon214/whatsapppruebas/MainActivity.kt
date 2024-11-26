package com.jluqgon214.whatsapppruebas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jluqgon214.whatsapppruebas.navigation.AppNavigation
import com.jluqgon214.whatsapppruebas.ui.theme.WhatsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsAppTheme {
                AppNavigation()
            }
        }
    }
}