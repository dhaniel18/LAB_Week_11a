package com.example.lab_week_11a

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "settingsStore"
)

class SettingsStore(private val context: Context) {

    val text: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[KEY_TEXT] ?: ""
        }

    suspend fun saveText(value: String) {
        context.dataStore.edit { preferences ->
            preferences[KEY_TEXT] = value
        }
    }

    companion object {
        val KEY_TEXT = stringPreferencesKey("key_text")
    }
}