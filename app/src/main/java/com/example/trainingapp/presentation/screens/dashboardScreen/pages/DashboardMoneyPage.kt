package com.example.trainingapp.presentation.screens.dashboardScreen.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.trainingapp.R
import com.example.trainingapp.presentation.components.AppSpacer
import com.example.trainingapp.presentation.components.AppText
import com.example.trainingapp.presentation.components.AppTextField
import com.example.trainingapp.presentation.screens.dashboardScreen.components.TransactionWidget
import com.example.trainingapp.utils.StaticDataUtils

@Composable
fun DashboardMoneyPage() {
    val ctx = LocalContext.current
    val items = remember {
        StaticDataUtils.getTransactionList()
    }
    val searchQuery = remember { mutableStateOf(TextFieldValue("")) }

    // Filter items based on search query
    val filteredItems = items.filter {
        it.cardName.contains(searchQuery.value.text, ignoreCase = true) || it.date.contains(
            searchQuery.value.text, ignoreCase = true
        ) || it.price.toString().contains(
            searchQuery.value.text, ignoreCase = true
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp)
            .background(color = Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Search Bar
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                AppTextField(
                    value = searchQuery.value.text,
                    onValueChange = {
                        searchQuery.value = TextFieldValue(it)
                    },
                    placeholder = stringResource(id = R.string.search),
                    isPassword = false,
                    keyboardType = KeyboardType.Text,
                )
            }

            AppSpacer(height = 20.dp)

            // Display filtered list of transactions
            if (filteredItems.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    AppText(
                        text = ctx.getString(R.string.no_data_found), isBold = true,
                    )
                }
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    itemsIndexed(filteredItems) { index, item ->
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
    }
}
