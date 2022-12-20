package com.andreesperanca.estudia.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.andreesperanca.estudia.ui.control.ControlPanelScreen
import com.andreesperanca.estudia.ui.settings.SettingsScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.ControlPanel.route
    ) {

        composable(route = Screen.ControlPanel.route) {
            ControlPanelScreen()
        }

        composable(route = Screen.Settings.route) {
            SettingsScreen()
        }
    }


}