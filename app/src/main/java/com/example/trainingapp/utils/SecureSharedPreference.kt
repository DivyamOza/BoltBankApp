package com.example.trainingapp.utils

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

/**
 * Secure shared preference
 *
 * @constructor
 *
 * @param context
 */
class SecureSharedPreference(context: Context) {

    /**
     * Master key alias
     */
    private val masterKeyAlias: MasterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    /**
     * Shared preferences
     */
    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        "secure_shared_prefs",
        masterKeyAlias,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    /**
     * Put string
     *
     * @param key
     * @param value
     */
    fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    /**
     * Get string
     *
     * @param key
     * @param defaultValue
     * @return
     */
    fun getString(key: String, defaultValue: String? = null): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    /**
     * Put int
     *
     * @param key
     * @param value
     */
    fun putInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    /**
     * Get int
     *
     * @param key
     * @param defaultValue
     * @return
     */
    fun getInt(key: String, defaultValue: Int = 0): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    /**
     * Put boolean
     *
     * @param key
     * @param value
     */
    fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    /**
     * Get boolean
     *
     * @param key
     * @param defaultValue
     * @return
     */
    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    /**
     * Remove
     *
     * @param key
     */
    fun remove(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    /**
     * Clear
     *
     */
    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}
