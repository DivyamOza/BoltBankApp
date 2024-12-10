package com.example.trainingapp.presentation.screens.splashScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.trainingapp.presentation.components.AppLogo
import com.example.trainingapp.ui.theme.Green

/**
 * Splash screen
 *
 * @param gotoSignUp
 * @receiver
 */
@Composable
fun SplashScreen(gotoSignUp: () -> Unit) {
    // Use LaunchedEffect to navigate after a delay
    LaunchedEffect(Unit) {
        // Delay for 2 seconds
        kotlinx.coroutines.delay(2000)
        gotoSignUp()
    }

    // Gradient background brush
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Green, Color.White)
    )

    // Splash UI
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = gradientBrush,
            ),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AppLogo()
        }
    }
}