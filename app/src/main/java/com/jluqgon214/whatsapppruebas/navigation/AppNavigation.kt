package com.jluqgon214.whatsapppruebas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jluqgon214.whatsapppruebas.data.WhatsAppViewModel
import com.jluqgon214.whatsapppruebas.screens.ChatScreen
import com.jluqgon214.whatsapppruebas.screens.MainScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val viewModel = WhatsAppViewModel()

    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") {
            MainScreen(navController, viewModel)
        }
        composable("ChatScreen") {
            ChatScreen(navController, viewModel)
        }
    }
}