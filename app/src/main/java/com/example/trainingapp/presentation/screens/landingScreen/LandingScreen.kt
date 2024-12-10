package com.example.trainingapp.presentation.screens.landingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainingapp.R
import com.example.trainingapp.presentation.components.AppButton
import com.example.trainingapp.presentation.components.AppLogo
import com.example.trainingapp.presentation.components.AppSpacer
import com.example.trainingapp.ui.theme.DarkGreen
import com.example.trainingapp.ui.theme.Green

/**
 * Landing screen
 *
 * @param gotoSignUp
 * @receiver
 */
@Preview
@Composable
fun LandingScreen(gotoSignUp: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { paddingValue ->
        Box(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize()
                .background(
                    Brush.sweepGradient(
                        colors = listOf(
                            DarkGreen,
                            Green,
                        ),
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // Top Column
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    AppSpacer(height = 55.dp)
                    AppLogo()
                    AppSpacer(height = 25.dp)
                    Text(
                        text = stringResource(id = R.string.tagline),
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                // Bottom Column
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    AppButton(
                        text = stringResource(id = R.string.login_title).toUpperCase(Locale.current),
                        backgroundColor = Color.Black,
                        onClick = {
                            // Navigate to Register Screen
                            gotoSignUp()
                        },
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    AppSpacer(height = 15.dp)
                    Text(
                        text = stringResource(id = R.string.login_subtitle),
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    AppSpacer(height = 10.dp)
                    Text(
                        text = stringResource(id = R.string.please_continue_title),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    AppSpacer(height = 10.dp)
                }
            }
        }
    }
}