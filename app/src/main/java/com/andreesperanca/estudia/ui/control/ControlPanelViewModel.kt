package com.andreesperanca.estudia.ui.control

import android.app.Application
import android.app.NotificationManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import com.andreesperanca.estudia.R
import com.andreesperanca.estudia.data.ControlPanelScreenState
import com.andreesperanca.estudia.services.sendNotification
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ControlPanelViewModel(private val app: Application) : AndroidViewModel(app) {

    private var _uiState = MutableStateFlow<ControlPanelScreenState>(ControlPanelScreenState.Pause)
    val uiState: StateFlow<ControlPanelScreenState> = _uiState.asStateFlow()

    fun changeState() {
        if (_uiState.value == ControlPanelScreenState.Pause) {
            _uiState.value = ControlPanelScreenState.Study
        } else {
            _uiState.value = ControlPanelScreenState.Pause
        }
    }


    fun showNotification(state: ControlPanelScreenState) {
        val notificationManager = ContextCompat.getSystemService(
            app,
            NotificationManager::class.java
        ) as NotificationManager

        if (state == ControlPanelScreenState.Pause) {
            showStudyNotification(notificationManager)
        } else {
            showPauseNotification(notificationManager)
        }
        changeState()
    }

    fun showStudyNotification(notificationManager: NotificationManager) {
        notificationManager.sendNotification(app.getString(R.string.notificationStudyDescription), app)
    }

    fun showPauseNotification(notificationManager: NotificationManager) {
        notificationManager.sendNotification(app.getString(R.string.notificationPauseDescription), app)
    }

}