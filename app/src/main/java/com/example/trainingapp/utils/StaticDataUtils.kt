package com.example.trainingapp.utils

import androidx.compose.runtime.mutableStateListOf
import com.example.trainingapp.domain.models.TransactionDataModel

object StaticDataUtils {

    fun getTransactionList(): MutableList<TransactionDataModel> {
        return mutableStateListOf(
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
}