package com.andreesperanca.estudia.repositories

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun fetchPomodoroTime(): Flow<Long?>
    fun fetchLongBreakTime(): Flow<Long?>
    fun fetchShortBreakTime(): Flow<Long?>
    fun fetchNotificationPreference(): Flow<Boolean?>
    fun fetchAutomaticCircularIndicator(): Flow<Boolean?>

    suspend fun saveNotificationPreference(notificationPref: Boolean)
    suspend fun saveAutomaticIndicatorPreference(automaticIndicator: Boolean)
    suspend fun saveLongBreakTime(longBreakTime: Long)
    suspend fun saveShortBreakTime(shortBreakTime: Long)
    suspend fun savePomodoroTime(pomodoroTime: Long)

}