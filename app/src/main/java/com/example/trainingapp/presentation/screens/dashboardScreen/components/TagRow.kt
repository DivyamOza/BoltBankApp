package com.example.trainingapp.presentation.screens.dashboardScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.trainingapp.ui.theme.Green

@Composable
fun TagRow(selectedTag: Int, onTagSelected: (Int) -> Unit, modifier: Modifier) {
    Column(modifier = modifier) {
        Divider(thickness = 5.dp, color = Green)
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            val icons = listOf(
                Icons.Filled.Home,
                Icons.Filled.CreditCard,
                Icons.Filled.AddCircle,
                Icons.Filled.CurrencyExchange,
                Icons.Filled.Settings
            )

            icons.forEachIndexed { index, icon ->
                IconButton(
                    onClick = { onTagSelected(index) }, modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Tag $index",
                        modifier = Modifier
                            .size(30.dp)
                            .let {
                                if (selectedTag == index) {
                                    it.graphicsLayer(
                                        scaleX = 1.2f, scaleY = 1.2f
                                    )
                                } else {
                                    it
                                }
                            },
                        tint = if (selectedTag == index) Green else Color.Black
                    )
                }
            }
        }
    }
}