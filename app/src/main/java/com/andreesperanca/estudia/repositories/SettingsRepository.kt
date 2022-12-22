package com.andreesperanca.estudia.repositories

import android.content.Context
import androidx.datastore.core.DataStore
import com.andreesperanca.estudia.data.UserPreferences

class SettingsRepository(
    private val userPreferences: DataStore<UserPreferences>,
    context: Context
) {
}