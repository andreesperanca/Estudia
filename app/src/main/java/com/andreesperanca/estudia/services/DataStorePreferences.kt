package com.andreesperanca.estudia.services

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStorePreferences(private val context: Context) {


    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("preferences")
        val USER_POMODORO_TIME_PREFERENCE = longPreferencesKey("pomodoroTime")
    }

    val getPomodoroTime: Flow<Long?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_POMODORO_TIME_PREFERENCE] ?: 0L
        }

    suspend fun savePomodoroTime(pomodoroTime: Long) {
        context.dataStore.edit { preferences ->
            preferences[USER_POMODORO_TIME_PREFERENCE] = pomodoroTime
        }
    }


}