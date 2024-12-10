package com.example.trainingapp.presentation.screens.dashboardScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainingapp.presentation.components.AppSpacer
import com.example.trainingapp.presentation.components.RoundedImageWithCoil

@Composable
fun UserStatusWidget(imgUrl: String = "", name: String = "", location: String = "") {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RoundedImageWithCoil(
            imageUrl = imgUrl,
            size = 60.dp,
        )
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            AppSpacer(height = 5.dp)
            Text(
                text = location,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}