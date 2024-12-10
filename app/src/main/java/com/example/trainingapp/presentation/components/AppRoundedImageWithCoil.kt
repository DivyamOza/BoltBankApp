package com.example.trainingapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

/**
 * Rounded image with coil
 *
 * @param imageUrl
 * @param size
 * @param backgroundColor
 * @param shape
 */
@Composable
fun RoundedImageWithCoil(
    imageUrl: String,
    size: Dp = 100.dp,
    backgroundColor: Color = Color.LightGray,
    shape: Shape = CircleShape
) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(shape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = imageUrl),
            contentDescription = "Rounded Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

