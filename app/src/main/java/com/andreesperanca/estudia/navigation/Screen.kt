package com.andreesperanca.estudia.navigation

sealed class Screen(val route: String) {

    object ControlPanel: Screen(route = "controlPanel_screen")
    object Settings: Screen(route = "settings_screen")

}
