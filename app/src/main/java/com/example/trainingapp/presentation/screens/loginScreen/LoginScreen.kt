package com.example.trainingapp.presentation.screens.loginScreen

import AppSwitch
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainingapp.R
import com.example.trainingapp.presentation.components.AppButton
import com.example.trainingapp.presentation.components.AppSpacer
import com.example.trainingapp.presentation.components.AppTextField
import com.example.trainingapp.ui.theme.Green
import com.example.trainingapp.utils.ValidationUtils

/**
 * Login screen
 *
 * @param gotoPrivacyPolicy
 * @param gotoOTP
 * @receiver
 * @receiver
 */
@Preview
@Composable
fun LoginScreen(gotoPrivacyPolicy: () -> Unit, gotoOTP: () -> Unit) {
    // Manage Context for Toast
    val context = LocalContext.current

    // State for the Phone Number
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var phoneNumberError by rememberSaveable { mutableStateOf<String?>(null) }

    // State for the password
    var password by rememberSaveable { mutableStateOf("") }
    var passwordError by rememberSaveable { mutableStateOf<String?>(null) }

    // State for the switch
    var isChecked by rememberSaveable { mutableStateOf(false) }

    // Check if login button should be enabled
    val isLoginButtonEnabled =
        phoneNumber.isNotEmpty() && phoneNumberError == null && password.isNotEmpty() && passwordError == null && isChecked

    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        // Bottom Column
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(color = Color.White)
        ) {
            AppSpacer(height = 50.dp)
            AppButton(
                text = stringResource(id = R.string.login_title),
                backgroundColor = if (isLoginButtonEnabled) Color.Black else Color.Gray,
                onClick = {
                    phoneNumberError = ValidationUtils.validatePhoneNumber(phoneNumber)
                    passwordError = ValidationUtils.validatePassword(password)

                    // Prepare error message based on validation checks
                    val errorMessage = when {
                        phoneNumber.isEmpty() -> "Please enter your phone number."
                        phoneNumberError != null -> "Please enter a valid phone number."
                        password.isEmpty() -> "Please enter your password."
                        passwordError != null -> "Please enter a valid password."
                        !isChecked -> "Please accept the terms and conditions."
                        else -> null
                    }

                    // Show the error message if there's an issue, otherwise proceed
                    if (errorMessage != null) {
                        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Logged In Successful!", Toast.LENGTH_SHORT).show()
                        gotoOTP()
                    }
                },
                modifier = Modifier.padding(horizontal = 60.dp),
            )
            AppSpacer(height = 15.dp)
            Text(
                text = "Forgot Password?", style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                ), textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 16.dp)
            )
            AppSpacer(height = 50.dp)
        }
    }) { paddingValue ->
        Box(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize()
                .background(
                    color = Color.White
                )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // Top Column
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Green)
                        .height(130.dp)
                ) {
                    AppSpacer(height = 25.dp)
                    Text(
                        text = stringResource(id = R.string.msg_welcome),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    AppSpacer(height = 10.dp)
                    Text(
                        text = stringResource(id = R.string.login_title),
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    AppSpacer(height = 30.dp)
                }

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                ) {
                    AppSpacer(height = 35.dp)
                    // Phone Number Field
                    AppTextField(
                        value = phoneNumber,
                        onValueChange = {
                            phoneNumber = it
                            phoneNumberError = ValidationUtils.validatePhoneNumber(it)
                        },
                        placeholder = stringResource(id = R.string.phone_no),
                        error = phoneNumberError,
                        isPassword = false,
                        keyboardType = KeyboardType.Phone,
                        maxLength = 10,
                        label = stringResource(id = R.string.phone_no)
                    )

                    AppSpacer(height = 20.dp)

                    // Password Field
                    AppTextField(
                        value = password,
                        onValueChange = {
                            password = it
                            passwordError = ValidationUtils.validatePassword(it)
                        },
                        placeholder = stringResource(id = R.string.password),
                        error = passwordError,
                        isPassword = true,
                        maxLength = 12,
                        label = stringResource(id = R.string.password)
                    )

                    AppSpacer(height = 15.dp)

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start

                    ) {
                        AppSwitch(isChecked = rememberSaveable { mutableStateOf(isChecked) },
                            onCheckedChange = { isCheckedValue ->
                                isChecked = isCheckedValue
                            })
                        AppSpacer(width = 20.dp)
                        AppSpacer(height = 10.dp)
                        Text(text = stringResource(id = R.string.terms_and_conditions),
                            style = TextStyle(
                                color = Color.Blue, fontSize = 16.sp, fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.clickable {
                                gotoPrivacyPolicy()
                            })
                    }
                }
            }
        }
    }
}