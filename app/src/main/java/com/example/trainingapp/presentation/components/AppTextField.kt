package com.example.trainingapp.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * App text field
 *
 * @param value
 * @param onValueChange
 * @param placeholder
 * @param isPassword
 * @param keyboardType
 * @param maxLength
 * @param modifier
 * @param error
 * @param label
 * @receiver
 */
@Preview
@Composable
fun AppTextField(
    value: String = "",
    onValueChange: (String) -> Unit = {},
    placeholder: String = "Enter text",
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    maxLength: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier,
    error: String? = null,
    label: String? = ""
) {
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            if (label != null) {
                AppText(label, fontSize = 11)
                AppSpacer(height = 7.dp)
            }
            TextField(
                value = value,
                onValueChange = { newValue ->
                    if (newValue.length <= maxLength) {
                        onValueChange(newValue)
                    } else {
                        onValueChange(newValue.take(maxLength))
                    }
                },
                placeholder = { Text(text = placeholder) },
                singleLine = true,
                isError = error != null,
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray, RoundedCornerShape(5.dp)),
                visualTransformation = if (isPassword && !isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
                trailingIcon = {
                    if (isPassword) {
                        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                            Icon(
                                imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = if (isPasswordVisible) "Hide password" else "Show password"
                            )
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType
                ),
                colors = androidx.compose.material3.TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, // Background color when focused
                    unfocusedContainerColor = Color.White, // Background color when not focused
                    disabledContainerColor = Color.White, // Background color when disabled
                    errorContainerColor = Color.White // Background color when in error state
                ),
                textStyle = TextStyle(
                    color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Medium
                )
            )
            error?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 5.dp, top = 5.dp
                        )
                )
            }
        }
    }
}
