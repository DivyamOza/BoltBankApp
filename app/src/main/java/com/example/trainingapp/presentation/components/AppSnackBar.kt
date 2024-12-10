package com.example.trainingapp.presentation.components

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * App snack bar host
 *
 * @param snackBarHostState
 * @param modifier
 */
@Composable
fun AppSnackBarHost(
    snackBarHostState: SnackbarHostState, modifier: Modifier = Modifier
) {
    SnackbarHost(
        hostState = snackBarHostState, snackbar = { data: SnackbarData ->
            Snackbar(
                snackbarData = data, actionOnNewLine = false
            )
        }, modifier = modifier
    )
}
