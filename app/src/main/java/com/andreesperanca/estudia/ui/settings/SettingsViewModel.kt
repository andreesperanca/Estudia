package com.andreesperanca.estudia.ui.settings

import androidx.lifecycle.ViewModel
import com.andreesperanca.estudia.repositories.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val repository: SettingsRepository
 ) : ViewModel() {


    fun fetchPomodoroTime(): Flow<Long?> = repository.fetchPomodoroTime()

    fun fetchLongBreakTime(): Flow<Long?> = repository.fetchLongBreakTime()

    fun fetchShortBreakTime(): Flow<Long?> = repository.fetchShortBreakTime()

    fun fetchNotificationPreference(): Flow<Boolean?> = repository.fetchNotificationPreference()

    fun fetchAutomaticCircularIndicator(): Flow<Boolean?> =
        repository.fetchAutomaticCircularIndicator()

    suspend fun saveNotificationPreference(notificationPref: Boolean) =
        repository.saveNotificationPreference(notificationPref)

    suspend fun saveAutomaticIndicatorPreference(automaticIndicator: Boolean) =
        repository.saveAutomaticIndicatorPreference(automaticIndicator)

    suspend fun saveLongBreakTime(longBreakTime: Long) = repository.saveLongBreakTime(longBreakTime)
    suspend fun saveShortBreakTime(shortBreakTime: Long) =
        repository.saveShortBreakTime(shortBreakTime)

    suspend fun savePomodoroTime(pomodoroTime: Long) = repository.savePomodoroTime(pomodoroTime)


}