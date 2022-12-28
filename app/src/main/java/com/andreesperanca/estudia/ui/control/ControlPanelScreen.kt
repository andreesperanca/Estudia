package com.andreesperanca.estudia.ui.control

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.andreesperanca.estudia.R
import com.andreesperanca.estudia.data.ControlPanelScreenState
import com.andreesperanca.estudia.navigation.Screen
import com.andreesperanca.estudia.ui.components.CircularTimeIndicator
import com.andreesperanca.estudia.ui.theme.EstudiaTheme


@Composable
fun ControlPanelScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: ControlPanelViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .padding(top = 24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        CircularTimeIndicator(
            titleText = (if (uiState == ControlPanelScreenState.ShortPause) {
                stringResource(id = R.string.shortPause)
            } else if (uiState == ControlPanelScreenState.LongPause) {
                stringResource(id = R.string.longPause)
            } else {
                stringResource(id = R.string.study)
            }),
            configButtonClick = {
                navHostController.navigate(Screen.Settings.route)
            },
            changeStateButtonClick = {
                viewModel.changeState()
            },
            totalTime =
            when (uiState) {
                ControlPanelScreenState.ShortPause -> { 1L }
                ControlPanelScreenState.Study -> { 1L }
                ControlPanelScreenState.LongPause -> { 1L }
            }
            ,
            timeIsOver = {
                viewModel.showNotification(state = uiState)
            }
        )
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewControlPanel() {
    val navController = rememberNavController()
    EstudiaTheme {
        ControlPanelScreen(navHostController = navController)
    }
}
