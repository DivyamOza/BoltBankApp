package com.example.trainingapp.domain.models

data class TransactionDataModel(
    val price: Number = 0.0,
    val isCredited: Boolean = false,
    val cardName: String = "",
    val date: String = ""
)