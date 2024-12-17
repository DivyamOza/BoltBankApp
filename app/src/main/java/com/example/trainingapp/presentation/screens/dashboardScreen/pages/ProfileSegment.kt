package com.example.trainingapp.presentation.screens.dashboardScreen.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.trainingapp.presentation.components.AppSpacer
import com.example.trainingapp.presentation.components.AppText
import com.example.trainingapp.ui.theme.Green
import com.example.trainingapp.ui.theme.LightGreenForBalance

@Composable
fun ProfileSegment(
    imageVector: ImageVector,
    text: String,
    notificationCount: Int = 0
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = text,
                tint = LightGreenForBalance,
                modifier = Modifier.size(30.dp)
            )
            AppSpacer(width = 10.dp)
            AppText(text = text, fontSize = 18, color = Color.Black)
        }

        if (notificationCount > 0) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Green, shape = CircleShape)
                    .border(1.dp, Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                AppText(
                    text = notificationCount.toString(),
                    color = Color.White,
                    isBold = true
                )
            }
        }
    }
    Divider(thickness = 1.dp, color = Color.LightGray)
    AppSpacer(height = 15.dp)
}
