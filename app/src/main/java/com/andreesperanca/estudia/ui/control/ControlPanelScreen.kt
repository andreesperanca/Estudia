package com.andreesperanca.estudia.ui.control

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.andreesperanca.estudia.R
import com.andreesperanca.estudia.models.ControlPanelScreenState
import com.andreesperanca.estudia.navigation.Screens
import com.andreesperanca.estudia.ui.components.CircularTimeIndicator
import com.andreesperanca.estudia.ui.theme.EstudiaTheme
import com.andreesperanca.estudia.util.converterTimeForCircularIndicator


@Composable
fun ControlPanelScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: ControlPanelViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()


    val notificationsPreference =
        viewModel.fetchNotificationPreference().collectAsState(initial = false).value!!
    val automaticIndicatorPreference = viewModel.fetchAutomaticCircularIndicator().collectAsState(
        initial = false
    ).value!!


    var widthLocal = LocalConfiguration.current.screenWidthDp.dp
    var heightLocal = LocalConfiguration.current.screenHeightDp.dp

    val size = if (widthLocal > heightLocal) heightLocal else widthLocal

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
            canvasSize = size,
            titleText =
            when (uiState) {
                ControlPanelScreenState.ShortPause -> {
                    stringResource(id = R.string.shortPause)
                }
                ControlPanelScreenState.LongPause -> {
                    stringResource(id = R.string.longPause)
                }
                else -> {
                    stringResource(id = R.string.study)
                }
            },
            configButtonClick = {
                navHostController.navigate(Screens.Settings.route)
            },
            changeStateButtonClick = {
                viewModel.manualChangeState()
            },
            totalTime =
            when (uiState) {
                ControlPanelScreenState.ShortPause -> {
                    viewModel.fetchShortBreakTime()
                        .collectAsState(initial = 99999).value!!.converterTimeForCircularIndicator()
                }
                ControlPanelScreenState.Study -> {
                    viewModel.fetchPomodoroTime()
                        .collectAsState(initial = 99999).value!!.converterTimeForCircularIndicator()
                }
                ControlPanelScreenState.LongPause -> {
                    viewModel.fetchLongBreakTime()
                        .collectAsState(initial = 99999).value!!.converterTimeForCircularIndicator()
                }
            },
            timeIsOver = {
                if (notificationsPreference) {
                    viewModel.showNotification(state = uiState)
                }
                viewModel.autoChangeState()
            },
            automaticPreference = automaticIndicatorPreference
        )
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewControlPanel() {
    val navController = rememberNavController()
    EstudiaTheme {
        ControlPanelScreen(
            navHostController = navController
        )
    }
}
