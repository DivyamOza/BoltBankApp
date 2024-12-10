package com.example.trainingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.trainingapp.presentation.components.AppStatusBar
import com.example.trainingapp.presentation.navigation.AppNavController
import com.example.trainingapp.ui.theme.TrainingAppTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main activity
 *
 * @constructor Create empty Main activity
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /**
     * On create
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingAppTheme {
                AppStatusBar()
                AppNavController()
            }
        }
    }
}

