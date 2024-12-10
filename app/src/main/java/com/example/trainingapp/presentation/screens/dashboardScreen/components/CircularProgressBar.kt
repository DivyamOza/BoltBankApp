package com.example.trainingapp.presentation.screens.dashboardScreen.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.trainingapp.presentation.components.AppText

@Composable
fun CircularProgressBar(
    percentage: Float,
    displayText: String = "Lorem Ipsum",
    progressColor: Color = Color(0xFFFFA000),
    backgroundColor: Color = Color(0xFFE0E0E0),
    size: Float = 100f,
    animationDuration: Int = 1000
) {
    // Animate the progress value
    val animatedPercentage by animateFloatAsState(
        targetValue = percentage,
        animationSpec = tween(durationMillis = animationDuration),
        label = ""
    )

    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(size.dp)) {
        Canvas(modifier = Modifier.size(size.dp)) {
            val strokeWidth = 12.dp.toPx()
            val diameter = size.dp.toPx()

            // Draw the background circle
            drawArc(
                color = backgroundColor,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                size = Size(diameter, diameter),
                style = Stroke(strokeWidth, cap = StrokeCap.Round)
            )
            // Draw the progress arc
            drawArc(
                color = progressColor,
                startAngle = -90f,
                sweepAngle = 360f * animatedPercentage,
                useCenter = false,
                size = Size(diameter, diameter),
                style = Stroke(strokeWidth, cap = StrokeCap.Round)
            )
        }

        // Display the percentage text
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AppText(
                text = "${(animatedPercentage * 100).toInt()}%",
                fontSize = 35,
                isBold = true,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            AppText(
                text = displayText,
                fontSize = 14,
                isBold = false,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}
