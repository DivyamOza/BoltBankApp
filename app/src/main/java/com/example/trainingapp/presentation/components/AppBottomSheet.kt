package com.example.trainingapp.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonModalBottomSheet(
    sheetState: SheetState, sheetContent: @Composable () -> Unit, content: @Composable () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = { /* Optionally handle dismissal here */ },
        sheetState = sheetState,
        modifier = Modifier.fillMaxSize(),
    ) {
        // The content displayed in the bottom sheet
        sheetContent()
    }
    // The main screen content
    content()
}
