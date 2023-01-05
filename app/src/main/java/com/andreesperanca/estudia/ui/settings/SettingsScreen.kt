package com.andreesperanca.estudia.ui.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.andreesperanca.estudia.R
import com.andreesperanca.estudia.services.DataStorePreferences
import com.andreesperanca.estudia.ui.components.SettingsItem
import com.andreesperanca.estudia.ui.components.SettingsTimerItem
import com.andreesperanca.estudia.ui.theme.EstudiaTheme
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen(
    navHostController: NavHostController,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val rememberCoroutineScope = rememberCoroutineScope()
    val verticalScrollState = rememberScrollState()

    val pomodoroTime = viewModel.fetchPomodoroTime().collectAsState(initial = 0).value
    val shortBreakTime = viewModel.fetchShortBreakTime().collectAsState(initial = 0).value
    val longBreakTime = viewModel.fetchLongBreakTime().collectAsState(initial = 0).value
    val notificationsPreference =
        viewModel.fetchNotificationPreference().collectAsState(initial = false).value
    val automaticIndicatorPreference =
        viewModel.fetchAutomaticCircularIndicator().collectAsState(initial = false).value

    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = MaterialTheme.colors.primary,
                    title = {
                        Text(
                            color = MaterialTheme.colors.onBackground,
                            style = MaterialTheme.typography.h5,
                            text = "Configurações"
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navHostController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = null,
                                tint = MaterialTheme.colors.onBackground
                            )
                        }
                    },
                )
            },
            content = {
                Column(
                    modifier = Modifier.verticalScroll(verticalScrollState),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SettingsItem(
                        modifier = Modifier,
                        settingTitle = "Notificações",
                        settingDescription = stringResource(id = R.string.notificationSettingDescription),
                        onClick = { notificationsPreference ->
                            rememberCoroutineScope.launch {
                                viewModel.saveNotificationPreference(notificationsPreference)
                            }
                        }, checked = notificationsPreference!!
                    )
                    SettingsItem(
                        settingTitle = "Cronômetro",
                        settingDescription = stringResource(id = R.string.timerSettingDescription),
                        onClick = { automaticIndicatorPreference ->
                            rememberCoroutineScope.launch {
                               viewModel.saveAutomaticIndicatorPreference(automaticIndicatorPreference)
                            }
                        },
                        checked = automaticIndicatorPreference!!
                    )

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        text = stringResource(id = R.string.timeSettings),
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Start
                    )

                    SettingsTimerItem(
                        titleDuration = "Pomodoro",
                        duration = pomodoroTime!!,
                        addClick = { pomodoroTime ->
                            rememberCoroutineScope.launch {
                                viewModel.savePomodoroTime(pomodoroTime)
                            }
                        },
                        removeClick = { pomodoroTime ->
                            rememberCoroutineScope.launch {
                                viewModel.savePomodoroTime(pomodoroTime)
                            }
                        },
                    )

                    SettingsTimerItem(
                        duration = shortBreakTime!!,
                        titleDuration = "Pausa curta",
                        addClick = { shortBreakTime ->
                            rememberCoroutineScope.launch {
                                viewModel.saveShortBreakTime(shortBreakTime)
                            }
                        },
                        removeClick = { shortBreakTime ->
                            rememberCoroutineScope.launch {
                                viewModel.saveShortBreakTime(shortBreakTime)
                            }
                        },
                    )

                    SettingsTimerItem(
                        duration = longBreakTime!!,
                        titleDuration = "Pausa longa",
                        addClick = { longBreakTime ->
                            rememberCoroutineScope.launch {
                                viewModel.saveLongBreakTime(longBreakTime)
                            }
                        },
                        removeClick = { longBreakTime ->
                            rememberCoroutineScope.launch {
                                viewModel.saveLongBreakTime(longBreakTime)
                            }

                        }
                    )
                }
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSettingsScreen() {
    EstudiaTheme {
        SettingsScreen(navHostController = rememberNavController())
    }
}