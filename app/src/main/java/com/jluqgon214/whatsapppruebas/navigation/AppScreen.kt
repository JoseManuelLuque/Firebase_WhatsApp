package com.jluqgon214.whatsapppruebas.navigation

sealed class AppScreen(val route: String) {
    object MainScreen: AppScreen("MainScreen")
    object ChatScreen: AppScreen("ChatScreen")
}