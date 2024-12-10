package com.example.trainingapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

/**
 * App button
 *
 * @param text
 * @param onClick
 * @param modifier
 * @param backgroundColor
 * @param contentColor
 * @param shape
 * @param enabled
 * @param fontSize
 * @receiver
 */
@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)
        .height(60.dp),
    backgroundColor: Color = Color.Black,
    contentColor: Color = Color.White,
    shape: Shape = RoundedCornerShape(5.dp),
    enabled: Boolean = true,
    fontSize: TextUnit = MaterialTheme.typography.titleLarge.fontSize
) {
    Button(
        onClick = onClick,
        modifier = modifier.then(
            Modifier
                .fillMaxWidth()
                .height(60.dp)
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enabled) backgroundColor else Color.Gray,
            contentColor = contentColor
        ),
        shape = shape,
        enabled = enabled
    ) {
        Text(text = text, fontSize = fontSize)
    }
}
