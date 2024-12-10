package com.example.trainingapp.presentation.screens.dashboardScreen.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.trainingapp.domain.models.TransactionDataModel
import com.example.trainingapp.presentation.components.AppSpacer
import com.example.trainingapp.presentation.screens.dashboardScreen.components.TransactionWidget

@Composable
fun DashboardMoneyPage() {
    val items = remember {
        mutableStateListOf(
            TransactionDataModel(
                price = 10000, isCredited = true, cardName = "VISA", date = "31-10-2024"
            ),
            TransactionDataModel(
                price = 500, isCredited = false, cardName = "MasterCard", date = "31-10-2024"
            ),
            TransactionDataModel(
                price = 4500, isCredited = false, cardName = "VISA", date = "02-11-2024"
            ),
            TransactionDataModel(
                price = 5000, isCredited = true, cardName = "MasterCard", date = "03-11-2024"
            ),
            TransactionDataModel(
                price = 3000, isCredited = false, cardName = "VISA", date = "25-11-2024"
            ),
            TransactionDataModel(
                price = 10000, isCredited = true, cardName = "VISA", date = "31-11-2024"
            ),
            TransactionDataModel(
                price = 4500, isCredited = false, cardName = "MasterCard", date = "02-11-2024"
            ),
            TransactionDataModel(
                price = 3000, isCredited = false, cardName = "VISA", date = "25-11-2024"
            ),
            TransactionDataModel(
                price = 10000, isCredited = true, cardName = "VISA", date = "31-11-2024"
            ),
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp)
            .background(color = Color.White)
    ) {
        // Use `itemsIndexed` for handling a state-backed list (SnapshotStateList)
        LazyColumn {
            itemsIndexed(items) { index, item ->
                TransactionWidget(
                    price = item.price,
                    isCredited = item.isCredited,
                    cardName = item.cardName,
                    date = item.date
                )
                AppSpacer(height = 10.dp)
            }
        }
    }
}
