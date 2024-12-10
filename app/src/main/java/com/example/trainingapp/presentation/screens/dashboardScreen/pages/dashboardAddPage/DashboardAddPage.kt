package com.example.trainingapp.presentation.screens.dashboardScreen.pages.dashboardAddPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.trainingapp.presentation.components.AppButton
import com.example.trainingapp.presentation.screens.dashboardScreen.components.CurrencyDropdown
import com.example.trainingapp.presentation.screens.dashboardScreen.pages.dashboardAddPage.components.CurrencyRow

@Composable
fun DashboardAddPage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Dropdown Menus for Currency
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CurrencyDropdown(label = "USD")
                CurrencyDropdown(label = "UAH")
            }

            // Exchange rate information
            Text(
                text = "1 USD = 27.34 UAH",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Amounts
            Column(modifier = Modifier.fillMaxWidth()) {
                CurrencyRow(label = "LOREM", amount = "$200")
                Spacer(modifier = Modifier.height(8.dp))
                CurrencyRow(label = "IPSUM", amount = "₴544,56")
            }

            // Button
            AppButton(
                text = "Lorem ipsum",
                onClick = { /*TODO: Add your action here*/ },
            )
        }
    }
}