package com.andreesperanca.estudia.di

import android.content.Context
import com.andreesperanca.estudia.di.DataStoreModule.provideDataStore
import com.andreesperanca.estudia.repositories.PanelControlRepository
import com.andreesperanca.estudia.repositories.PanelControlRepositoryImpl
import com.andreesperanca.estudia.repositories.SettingsRepository
import com.andreesperanca.estudia.repositories.SettingsRepositoryImpl
import com.andreesperanca.estudia.services.DataStorePreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Singleton
    @Provides
    fun provideDataStore(
        @ApplicationContext context: Context
    ): DataStorePreferences {
        return DataStorePreferences(
            context = context
        )
    }
}

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providePanelControlRepository(
        dataStorePreferences: DataStorePreferences
    ): PanelControlRepository {
        return PanelControlRepositoryImpl(
            dataStorePreferences = dataStorePreferences
        )
    }
}


@Module
@InstallIn(SingletonComponent::class)
object SettingsRepositoryModule {
    @Singleton
    @Provides
    fun provideSettingsRepository(
        dataStorePreferences: DataStorePreferences
    ): SettingsRepository {
        return SettingsRepositoryImpl(
            dataStorePreferences = dataStorePreferences
        )
    }
}