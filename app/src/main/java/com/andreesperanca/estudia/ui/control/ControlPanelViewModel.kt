package com.andreesperanca.estudia.ui.control

import android.app.Application
import android.app.NotificationManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.andreesperanca.estudia.R
import com.andreesperanca.estudia.models.ControlPanelScreenState
import com.andreesperanca.estudia.repositories.PanelControlRepository
import com.andreesperanca.estudia.services.sendNotification
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class ControlPanelViewModel
@Inject constructor(
    private val repository: PanelControlRepository,
    private val app: Application,
) : ViewModel() {

    private var _uiState =
        MutableStateFlow<ControlPanelScreenState>(ControlPanelScreenState.Study)
    val uiState: StateFlow<ControlPanelScreenState> = _uiState.asStateFlow()

    private var _countPomodoro: Int = 0
    val countPomodoro: Int
        get() = _countPomodoro

    fun fetchPomodoroTime(): Flow<Long?> = repository.fetchPomodoroTime()

    fun fetchLongBreakTime(): Flow<Long?> = repository.fetchLongBreakTime()

    fun fetchShortBreakTime(): Flow<Long?> = repository.fetchShortBreakTime()

    fun fetchNotificationPreference(): Flow<Boolean?> = repository.fetchNotificationPreference()

    fun fetchAutomaticCircularIndicator(): Flow<Boolean?> = repository.fetchAutomaticCircularIndicator()

    fun autoChangeState() {
        when (_uiState.value) {
            ControlPanelScreenState.Study -> {
                if (_countPomodoro == 4) {
                    _uiState.value = ControlPanelScreenState.LongPause
                    pomodoroCounter()
                } else {
                    _countPomodoro++
                    _uiState.value = ControlPanelScreenState.ShortPause
                }
            }
            ControlPanelScreenState.ShortPause -> {
                _uiState.value = ControlPanelScreenState.Study
            }
            else -> {
                _uiState.value = ControlPanelScreenState.Study
            }
        }
    }

    fun manualChangeState() {
        when (_uiState.value) {
            ControlPanelScreenState.Study -> {
                _uiState.value = ControlPanelScreenState.ShortPause
            }
            ControlPanelScreenState.ShortPause -> {
                _uiState.value = ControlPanelScreenState.LongPause
            }
            ControlPanelScreenState.LongPause -> {
                _uiState.value = ControlPanelScreenState.Study
            }
        }
    }

    private fun pomodoroCounter() {
        if (_countPomodoro >= 4) {
            _countPomodoro = 0
        }
    }

    fun showNotification(state: ControlPanelScreenState) {
        val notificationManager = ContextCompat.getSystemService(
            app,
            NotificationManager::class.java
        ) as NotificationManager

        if (state == ControlPanelScreenState.ShortPause) {
            showStudyNotification(notificationManager)
        } else {
            showPauseNotification(notificationManager)
        }
    }

    private fun showStudyNotification(notificationManager: NotificationManager) {
        notificationManager.sendNotification(
            app.getString(R.string.notificationStudyDescription),
            app
        )
    }

    private fun showPauseNotification(notificationManager: NotificationManager) {
        notificationManager.sendNotification(
            app.getString(R.string.notificationPauseDescription),
            app
        )
    }
}
