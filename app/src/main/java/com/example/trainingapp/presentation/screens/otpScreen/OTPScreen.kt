package com.example.trainingapp.presentation.screens.otpScreen

import android.Manifest
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainingapp.R
import com.example.trainingapp.presentation.components.AppButton
import com.example.trainingapp.presentation.components.AppSpacer
import com.example.trainingapp.presentation.screens.otpScreen.components.OtpTextField
import com.example.trainingapp.ui.theme.Green
import com.example.trainingapp.utils.NotificationUtils
import com.example.trainingapp.utils.SecureSharedPreference

@Composable
fun OTPScreen(gotoDashboard: () -> Unit) {
    val context = LocalContext.current

    // Use remember to generate OTP only once during the composable lifecycle
    val otp = rememberSaveable { NotificationUtils.generateOTP() }

    // State to hold OTP digits
    var otpDigits by rememberSaveable { mutableStateOf(List(4) { "" }) }

    // FocusRequesters for each OTP field
    val focusRequesters = List(4) { FocusRequester() }

    // Check if verify button should be enabled
    val isVerifyButtonEnabled =
        otpDigits.joinToString("").isNotEmpty() && otpDigits.joinToString("").isNotBlank()

    // Permission launcher for POST_NOTIFICATIONS
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            NotificationUtils.showNotification(context, otp = otp)
        } else {
            Toast.makeText(context, "Notification Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    // Launch the permission request in a LaunchedEffect to avoid triggering during composable initialization
    LaunchedEffect(Unit) {
        permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { paddingValue ->
        Box(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // Top Section
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Green)
                        .height(110.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.verification),
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                AppSpacer(height = 50.dp)

                // Bottom Section
                Row(
                    modifier = Modifier
                        .padding(horizontal = 50.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    otpDigits.forEachIndexed { index, value ->
                        OtpTextField(
                            modifier = Modifier
                                .weight(1f)
                                .focusRequester(focusRequesters[index])
                                .height(100.dp),
                            otpText = value,
                            otpCount = 1,
                            onOtpTextChange = { newOtp, isCompleted ->
                                val updatedOtp = otpDigits.toMutableList().apply {
                                    this[index] = newOtp
                                }
                                otpDigits = updatedOtp

                                // Move to next OTP field when completed
                                if (isCompleted && index < otpDigits.size - 1) {
                                    focusRequesters[index + 1].requestFocus()
                                }
                            },
                        )
                    }
                }

                AppSpacer(height = 30.dp)

                AppButton(text = stringResource(id = R.string.verify),
                    backgroundColor = if (isVerifyButtonEnabled) Color.Black else Color.Gray,
                    onClick = {
                        if (!isVerifyButtonEnabled) {
                            Toast.makeText(
                                context, "Please enter OTP first!!", Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            if (otpDigits.joinToString("") == otp) {
                                Toast.makeText(
                                    context, "OTP Verified Successfully!", Toast.LENGTH_SHORT
                                ).show()
                                // TODO: NEED TO MANAGE SHARED-PREFERENCE
                                /*NotificationUtils.showNotification(
                                    context, otp
                                )*/ // Show notification on success
                                /*SecureSharedPreference(context).putBoolean(
                                    "isLoggedIn",
                                    value = true
                                )*/
                                gotoDashboard()
                            } else {
                                Toast.makeText(
                                    context, "Invalid OTP. Please try again.", Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    })
            }
        }
    }
}
