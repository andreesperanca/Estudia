package com.andreesperanca.estudia.repositories

import com.andreesperanca.estudia.services.DataStorePreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(private val dataStorePreferences: DataStorePreferences) : SettingsRepository {

    override fun fetchPomodoroTime(): Flow<Long?> = dataStorePreferences.getPomodoroTime

    override fun fetchLongBreakTime(): Flow<Long?> = dataStorePreferences.getLongBreakTime

    override fun fetchShortBreakTime(): Flow<Long?> = dataStorePreferences.getShortBreakTime

    override fun fetchNotificationPreference(): Flow<Boolean?> = dataStorePreferences.getNotificationPreference

    override fun fetchAutomaticCircularIndicator(): Flow<Boolean?> = dataStorePreferences.getAutomaticIndicatorPreference

    override suspend fun saveNotificationPreference(notificationPref: Boolean) = dataStorePreferences.saveNotificationPreference(notificationPref)

    override suspend fun saveAutomaticIndicatorPreference(automaticIndicator: Boolean) = dataStorePreferences.saveAutomaticIndicatorPreference(automaticIndicator)

    override suspend fun saveLongBreakTime(longBreakTime: Long) = dataStorePreferences.saveLongBreakTime(longBreakTime)

    override suspend fun saveShortBreakTime(shortBreakTime: Long) = dataStorePreferences.saveShortBreakTime(shortBreakTime)

    override suspend fun savePomodoroTime(pomodoroTime: Long) = dataStorePreferences.savePomodoroTime(pomodoroTime)
}