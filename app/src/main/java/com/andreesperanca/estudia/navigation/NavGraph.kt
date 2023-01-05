package com.andreesperanca.estudia.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.andreesperanca.estudia.ui.control.ControlPanelScreen
import com.andreesperanca.estudia.ui.settings.SettingsScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screens.ControlPanel.route
    ) {

        composable(route = Screens.ControlPanel.route) {
            ControlPanelScreen(
                navHostController = navController)
        }

        composable(route = Screens.Settings.route) {
            SettingsScreen(navHostController = navController)
        }
    }


}