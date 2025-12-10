package com.example.lab_week_11a

import android.app.Application

class SettingsApplication : Application() {
    lateinit var settingsStore: SettingsStore

    override fun onCreate() {
        super.onCreate()
        settingsStore = SettingsStore(this)
    }
}


    companion object {
        val KEY_TEXT = stringPreferencesKey("key_text")
    }
}
