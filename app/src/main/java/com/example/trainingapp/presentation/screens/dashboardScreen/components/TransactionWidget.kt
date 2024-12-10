package com.example.trainingapp.presentation.screens.dashboardScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trainingapp.presentation.components.AppSpacer
import com.example.trainingapp.presentation.components.AppText
import com.example.trainingapp.ui.theme.Green

@Preview
@Composable
fun TransactionWidget(
    price: Number = 0.0, isCredited: Boolean = false, cardName: String = "", date: String = ""
) {
    val priceTxt = if (isCredited) "+ $price" else "- $price"

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color.White)
            .border(
                1.5.dp, if (isCredited) Green else Color.Red, RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
            ) {
                AppText(
                    text = cardName, color = Color.Black, isBold = true, fontSize = 18
                )
                AppSpacer(height = 4.dp)
                AppText(
                    text = date, color = Color.Gray, isThin = true, fontSize = 12
                )
            }
            AppText(
                text = priceTxt,
                color = if (isCredited) Green else Color.Red,
                isBold = true,
                fontSize = 24
            )
        }
    }
}

