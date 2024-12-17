package com.example.trainingapp.utils

import android.content.Context
import android.os.LocaleList
import androidx.navigation.NavController
import com.example.trainingapp.core.Constants
import com.example.trainingapp.presentation.navigation.ScreenName
import java.util.Locale

object CommonUtils {
    const val PRIVACY_POLICY_URL = "https://www.lipsum.com/"

    /**
     * Set locale
     *
     * @param locale
     */
    fun Context.setLocale(locale: Locale) {
        val configuration = resources.configuration
        val localeList = LocaleList(locale)
        LocaleList.setDefault(localeList)
        configuration.setLocales(localeList)
        configuration.setLocale(locale)

        @Suppress("DEPRECATION")
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }

    /**
     * Logout
     *
     * @param navController
     * @param context
     */
    fun logout(navController: NavController, context: Context) {
        // Clear login state from SecureSharedPreference
        SecureSharedPreference(context).putBoolean(Constants.PREF_IS_LOGGED_IN, false)

        // Navigate to the LOGIN_SCREEN and clear the back stack
        navController.navigate(ScreenName.LOGIN_SCREEN) {
            popUpTo(0) { inclusive = true } // Clear all previous navigation history
        }
    }
}