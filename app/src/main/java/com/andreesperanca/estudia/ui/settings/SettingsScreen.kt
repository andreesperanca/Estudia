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
import com.andreesperanca.estudia.R
import com.andreesperanca.estudia.services.DataStorePreferences
import com.andreesperanca.estudia.ui.components.SettingsItem
import com.andreesperanca.estudia.ui.components.SettingsTimerItem
import com.andreesperanca.estudia.ui.theme.EstudiaTheme
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen() {

    val verticalScrollState = rememberScrollState()
    // context
    val context = LocalContext.current
    //scope de coroutine para compose
    val scope = rememberCoroutineScope()
    //datastore
    val datastore = DataStorePreferences(context)

    val pomodoroTime = datastore.getPomodoroTime.collectAsState(0)
    val shortBreakTime = datastore.getShortBreakTime.collectAsState(0)
    val longBreakTime = datastore.getLongBreakTime.collectAsState(0)
    val notificationsPreference = datastore.getNotificationPreference.collectAsState(false)
    val automaticIndicatorPreference =
        datastore.getAutomaticIndicatorPreference.collectAsState(false)

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
                        IconButton(onClick = {}) {
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
                            scope.launch {
                                datastore.saveNotificationPreference(
                                    notificationsPreference
                                )
                            }
                        }, checked = notificationsPreference.value
                    )
                    SettingsItem(
                        settingTitle = "Cronômetro",
                        settingDescription = stringResource(id = R.string.timerSettingDescription),
                        onClick = { automaticIndicatorPreference ->
                            scope.launch {
                                datastore.saveAutomaticIndicatorPreference(
                                    automaticIndicatorPreference
                                )
                            }
                        },
                        checked = automaticIndicatorPreference.value
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
                        duration = pomodoroTime.value!!,
                        addClick = { pomodoroTime ->
                            scope.launch {
                                datastore.savePomodoroTime(
                                    pomodoroTime
                                )
                            }
                        },
                        removeClick = { pomodoroTime ->
                            scope.launch {
                                datastore.savePomodoroTime(
                                    pomodoroTime
                                )
                            }
                        },
                    )

                    SettingsTimerItem(
                        duration = shortBreakTime.value!!,
                        titleDuration = "Pausa curta",
                        addClick = { shortBreakTime ->
                            scope.launch {
                                datastore.saveShortBreakTime(shortBreakTime)
                            }
                        },
                        removeClick = { shortBreakTime ->
                            scope.launch {
                                datastore.saveShortBreakTime(shortBreakTime)
                            }
                        },
                    )

                    SettingsTimerItem(
                        duration = longBreakTime.value!!,
                        titleDuration = "Pausa longa",
                        addClick = { longBreakTime ->
                            scope.launch {
                                datastore.saveLongBreakTime(longBreakTime)
                            }
                        },
                        removeClick = { longBreakTime ->
                            scope.launch {
                                datastore.saveLongBreakTime(longBreakTime)
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
        SettingsScreen()
    }
}