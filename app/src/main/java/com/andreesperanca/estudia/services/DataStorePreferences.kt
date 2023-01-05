package com.andreesperanca.estudia.services

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.andreesperanca.estudia.util.converterMinutes
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStorePreferences
@Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("preferences")
        val USER_POMODORO_TIME_PREFERENCE = longPreferencesKey("pomodoroTime")
        val USER_SHORT_BREAK_TIME_PREFERENCE = longPreferencesKey("shortBreakTime")
        val USER_LONG_BREAK_TIME_PREFERENCE = longPreferencesKey("longBreakTime")
        val USER_NOTIFICATIONS_PREFERENCE = booleanPreferencesKey("notificationsPreference")
        val USER_AUTOMATIC_INDICATOR_PREFERENCE = booleanPreferencesKey("automaticPreference")
    }

    /** DEFAULTS VALUES */
    private val DEFAULT_POMODORO_TIME = 1800L
    private val DEFAULT_SHORT_BREAK_TIME = 300L
    private val DEFAULT_LONG_BREAK_TIME = 900L
    private val DEFAULT_NOTIFICATION_PREFERENCE = true
    private val DEFAULT_AUTOMATIC_CIRCULAR_INDICATOR = true

    val getPomodoroTime: Flow<Long?> = context.dataStore.data.map { preferences ->
        preferences[USER_POMODORO_TIME_PREFERENCE] ?: DEFAULT_POMODORO_TIME.converterMinutes()
    }
    val getShortBreakTime: Flow<Long?> = context.dataStore.data.map { preferences ->
        preferences[USER_SHORT_BREAK_TIME_PREFERENCE] ?: DEFAULT_SHORT_BREAK_TIME.converterMinutes()
    }

    val getLongBreakTime: Flow<Long?> = context.dataStore.data.map { preferences ->
        preferences[USER_LONG_BREAK_TIME_PREFERENCE] ?: DEFAULT_LONG_BREAK_TIME.converterMinutes()
    }

    val getNotificationPreference: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[USER_NOTIFICATIONS_PREFERENCE] ?: DEFAULT_NOTIFICATION_PREFERENCE
    }

    val getAutomaticIndicatorPreference: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[USER_AUTOMATIC_INDICATOR_PREFERENCE] ?: DEFAULT_AUTOMATIC_CIRCULAR_INDICATOR
    }

    suspend fun saveNotificationPreference(notificationPref: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[USER_NOTIFICATIONS_PREFERENCE] = notificationPref
        }
    }

    suspend fun saveAutomaticIndicatorPreference(automaticIndicator: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[USER_AUTOMATIC_INDICATOR_PREFERENCE] = automaticIndicator
        }
    }

    suspend fun saveLongBreakTime(longBreakTime: Long) {
        context.dataStore.edit { preferences ->
            preferences[USER_LONG_BREAK_TIME_PREFERENCE] = longBreakTime
        }
    }

    suspend fun saveShortBreakTime(shortBreakTime: Long) {
        context.dataStore.edit { preferences ->
            preferences[USER_SHORT_BREAK_TIME_PREFERENCE] = shortBreakTime
        }
    }

    suspend fun savePomodoroTime(pomodoroTime: Long) {
        context.dataStore.edit { preferences ->
            preferences[USER_POMODORO_TIME_PREFERENCE] = pomodoroTime
        }
    }


}