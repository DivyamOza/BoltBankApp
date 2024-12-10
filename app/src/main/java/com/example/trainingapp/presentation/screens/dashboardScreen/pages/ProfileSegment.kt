package com.example.trainingapp.presentation.screens.dashboardScreen.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trainingapp.presentation.components.AppSpacer
import com.example.trainingapp.presentation.components.AppText
import com.example.trainingapp.ui.theme.LightGreenForBalance

/**
 * Profile segment
 *
 * @param imageVector
 * @param text
 * @param notificationCount
 */
@Preview
@Composable
fun ProfileSegment(imageVector: ImageVector, text: String, notificationCount: Int = 0) {
    Column(
        horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = imageVector, contentDescription = text, tint = LightGreenForBalance
            )
            AppSpacer(width = 10.dp)
            AppText(text = text)

        }
        Divider(thickness = 1.dp)
    }
}