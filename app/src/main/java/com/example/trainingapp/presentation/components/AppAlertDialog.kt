package com.example.trainingapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppAlertDialog(
    shouldShowDialog: MutableState<Boolean>,
    title: String,
    subTitle: String,
    isTwoButton: Boolean,
    confirmButtonText: String? = "",
    cancelButtonText: String? = "",
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    if (shouldShowDialog.value) {
        AlertDialog(icon = {
            Icon(Icons.AutoMirrored.Filled.Logout, contentDescription = "Example Icon")
        }, title = {
            Text(text = title)
        }, text = {
            Text(text = subTitle)
        }, onDismissRequest = {
            onDismiss()
        }, confirmButton = {
            TextButton(onClick = {
                onConfirm()
            }) {
                Text("Confirm")
            }
        }, dismissButton = {
            TextButton(onClick = {
                onDismiss()
            }) {
                Text("Dismiss")
            }
        })
    }
}