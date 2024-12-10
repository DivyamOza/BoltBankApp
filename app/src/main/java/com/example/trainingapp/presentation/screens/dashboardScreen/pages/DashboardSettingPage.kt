package com.example.trainingapp.presentation.screens.dashboardScreen.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.trainingapp.presentation.components.AppText

@Composable
fun DashboardSettingPage() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AppText(
            "The wheels are in motion for that...",
            isBold = true
        )
    }
}