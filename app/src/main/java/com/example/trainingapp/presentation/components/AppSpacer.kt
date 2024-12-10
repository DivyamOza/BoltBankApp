package com.example.trainingapp.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * App Spacer
 *
 * @param width
 * @param height
 */
@Composable
fun AppSpacer(
    width: Dp = 0.dp, height: Dp = 0.dp
) {
    Spacer(modifier = Modifier.size(width, height))
}
