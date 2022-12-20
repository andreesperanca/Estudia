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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.andreesperanca.estudia.ControlPanelViewModel
import com.andreesperanca.estudia.R
import com.andreesperanca.estudia.data.ControlPanelScreenState
import com.andreesperanca.estudia.ui.components.CircularTimeIndicator
import com.andreesperanca.estudia.ui.theme.EstudiaTheme


@Composable
fun ControlPanelScreen(
    modifier: Modifier = Modifier,
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
            titleText = if (uiState == ControlPanelScreenState.Pause) {
                stringResource(id = R.string.pause)
            } else {
                stringResource(id = R.string.study)
            },
            configButtonClick = {
            },
            changeStateButtonClick = {
                viewModel.changeState()
            },
            totalTime = if (uiState == ControlPanelScreenState.Pause) {
                3L
            } else {
                5L
            },
            timeIsOver = {
                viewModel.showNotification(state = uiState)
            }
        )
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewControlPanel() {
    EstudiaTheme {
        ControlPanelScreen()
    }
}
