package com.andreesperanca.estudia.repositories

import kotlinx.coroutines.flow.Flow

interface PanelControlRepository {
    fun fetchPomodoroTime(): Flow<Long?>
    fun fetchLongBreakTime(): Flow<Long?>
    fun fetchShortBreakTime(): Flow<Long?>
    fun fetchNotificationPreference(): Flow<Boolean?>
    fun fetchAutomaticCircularIndicator(): Flow<Boolean?>
}
