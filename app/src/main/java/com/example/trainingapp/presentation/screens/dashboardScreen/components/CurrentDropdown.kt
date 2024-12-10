package com.example.trainingapp.presentation.screens.dashboardScreen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CurrencyDropdown(label: String) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(label) }

    Box(modifier = Modifier
        .width(100.dp)
        .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
        .clickable(onClick = {
            expanded = true
        }) // Removed the unnecessary MutableInteractionSource
        .padding(horizontal = 8.dp, vertical = 4.dp)) {
        Text(text = selectedOption)
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(text = { Text("USD") }, onClick = {
                selectedOption = "USD"
                expanded = false
            })
            DropdownMenuItem(text = { Text("UAH") }, onClick = {
                selectedOption = "UAH"
                expanded = false
            })
        }
    }
}
