package com.example.trainingapp.presentation.screens.dashboardScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trainingapp.R
import com.example.trainingapp.presentation.components.AppText
import com.example.trainingapp.ui.theme.DarkGreen
import com.example.trainingapp.ui.theme.DarkerGreen
import com.example.trainingapp.ui.theme.LightGreenForBalance

/**
 * Current balance
 *
 * @param currentBalance
 */
@Preview
@Composable
fun CurrentBalance(currentBalance: Double = 0.0) {
    val ctx = LocalContext.current
    Box(
        modifier = Modifier
            .height(55.dp)
            .fillMaxSize()
            .height(55.dp)
            .background(color = LightGreenForBalance)
            .padding(horizontal = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            AppText(
                text = ctx.getString(R.string.current_balance),
                color = DarkerGreen,
                fontSize = 14,
                isBold = true,
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(bottom = 15.dp)
            )
            AppText(
                text = "₹$currentBalance",
                color = Color.Black,
                fontSize = 25,
                isBold = true,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}