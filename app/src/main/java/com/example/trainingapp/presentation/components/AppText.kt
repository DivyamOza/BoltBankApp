package com.example.trainingapp.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

/**
 * App text
 *
 * @param text
 * @param fontSize
 * @param color
 * @param maxLines
 * @param isBold
 * @param isThin
 * @param fontFamily
 * @param textAlign
 * @param letterSpacing
 * @param modifier
 */
@Composable
fun AppText(
    text: String,
    fontSize: Int = 16,
    color: Color = Color.Black,
    maxLines: Int = Int.MAX_VALUE,
    isBold: Boolean = false,
    isThin: Boolean = false,
    fontFamily: FontFamily? = null,
    textAlign: TextAlign = TextAlign.Start,
    letterSpacing: Float = 0f,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = TextStyle(
            color = color,
            fontSize = fontSize.sp,
            fontWeight = if (isBold) FontWeight.Bold else if (isThin) FontWeight.W300 else FontWeight.Normal,
            fontFamily = fontFamily,
            letterSpacing = letterSpacing.sp,
        ),
        maxLines = maxLines,
        textAlign = textAlign,
        modifier = modifier
    )
}
