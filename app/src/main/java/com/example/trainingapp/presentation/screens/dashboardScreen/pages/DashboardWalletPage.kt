package com.example.trainingapp.presentation.screens.dashboardScreen.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import com.example.trainingapp.R
import com.example.trainingapp.presentation.screens.dashboardScreen.components.CreditCardBack
import com.example.trainingapp.presentation.screens.dashboardScreen.components.CreditCardFront
import com.example.trainingapp.presentation.screens.dashboardScreen.components.FlippableCreditCard

@OptIn(ExperimentalUnitApi::class)
@Preview
@Composable
fun DashboardWalletPage() {
    var isFlipped1 by remember { mutableStateOf(false) }
    var isFlipped2 by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { isFlipped1 = !isFlipped1 }) {
                FlippableCreditCard(isFlipped = isFlipped1, cardFront = {
                    CreditCardFront(
                        cardNumber = "1234  5678  9012  3456",
                        cardHolderName = "John Doe",
                        expiryDate = "12/25",
                        backgroundDrawable = R.drawable.ic_blue_2,
                        isBlue = true
                    )
                }, cardBack = {
                    CreditCardBack(cvv = "123")
                })
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { isFlipped2 = !isFlipped2 }) {
                FlippableCreditCard(isFlipped = isFlipped2, cardFront = {
                    CreditCardFront(
                        cardNumber = "2406  2000  0109  1964",
                        cardHolderName = "John Doe",
                        expiryDate = "05/26",
                        backgroundDrawable = R.drawable.ic_green_2,
                        isBlue = false
                    )
                }, cardBack = {
                    CreditCardBack(cvv = "269")
                })
            }
        }
    }
}