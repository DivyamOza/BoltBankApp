package com.example.trainingapp.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.tooling.preview.Preview
import com.example.trainingapp.ui.theme.Green
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * App status bar
 *
 */
@Preview
@Composable
fun AppStatusBar() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = false
    val greenColor = Green

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = greenColor, darkIcons = useDarkIcons
        )
    }
}