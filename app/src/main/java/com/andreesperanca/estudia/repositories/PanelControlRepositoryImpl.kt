package com.andreesperanca.estudia.repositories

import com.andreesperanca.estudia.services.DataStorePreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PanelControlRepositoryImpl @Inject constructor(
    private val dataStorePreferences: DataStorePreferences
) : PanelControlRepository {

    override fun fetchPomodoroTime(): Flow<Long?> = dataStorePreferences.getPomodoroTime

    override fun fetchLongBreakTime(): Flow<Long?> = dataStorePreferences.getLongBreakTime

    override fun fetchShortBreakTime(): Flow<Long?> = dataStorePreferences.getShortBreakTime

    override fun fetchNotificationPreference(): Flow<Boolean?> =
        dataStorePreferences.getNotificationPreference

    override fun fetchAutomaticCircularIndicator(): Flow<Boolean?> =
        dataStorePreferences.getAutomaticIndicatorPreference
}
