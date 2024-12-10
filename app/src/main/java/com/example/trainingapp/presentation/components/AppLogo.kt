package com.example.trainingapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainingapp.R

/**
 * App logo
 *
 */
@Composable
fun AppLogo() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color.White),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(id = R.string.company_logo_character),
            style = TextStyle(fontSize = 90.sp, fontWeight = FontWeight.Bold)
        )
    }
}