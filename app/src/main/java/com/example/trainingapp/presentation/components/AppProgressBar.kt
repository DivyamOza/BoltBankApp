package com.example.trainingapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.trainingapp.ui.theme.DarkerGreen
import com.example.trainingapp.ui.theme.Green
import com.example.trainingapp.ui.theme.LightGreen

/**
 * App progress bar
 *
 */
@Composable
fun AppProgressBar() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            color = Green,
            trackColor = DarkerGreen
        )
    }
}