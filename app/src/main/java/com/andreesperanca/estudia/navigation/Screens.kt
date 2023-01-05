package com.andreesperanca.estudia.navigation

sealed class Screens(val route: String) {
    object ControlPanel: Screens(route = "controlPanel_screen")
    object Settings: Screens(route = "settings_screen")
}
