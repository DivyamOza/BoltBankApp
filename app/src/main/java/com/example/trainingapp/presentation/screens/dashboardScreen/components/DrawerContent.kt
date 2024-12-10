package com.example.trainingapp.presentation.screens.dashboardScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trainingapp.presentation.components.AppButton
import com.example.trainingapp.presentation.components.AppSpacer
import com.example.trainingapp.presentation.screens.dashboardScreen.pages.ProfileSegment
import com.example.trainingapp.ui.theme.Green
import com.example.trainingapp.utils.SecureSharedPreference

@Preview
@Composable
fun DrawerContent(modifier: Modifier = Modifier, onClose: () -> Unit) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column {
            // Top Section
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Green)
                    .height(110.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    UserStatusWidget(
                        imgUrl = "https://pngfre.com/wp-content/uploads/virat-kohli-poster.png",
                        name = "Mr. Virat Kohli",
                        location = "Pune, India"
                    )
                    IconButton(onClick = {
                        onClose()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Close",
                            tint = Color.White,
                        )
                    }
                }
            }
            AppSpacer(height = 20.dp)
            ProfileSegment(
                imageVector = Icons.Filled.MailOutline,
                text = "Alex",
                notificationCount = 3
            )
            AppSpacer(height = 10.dp)
            ProfileSegment(
                imageVector = Icons.Filled.MailOutline,
                text = "Alex",
                notificationCount = 3
            )
            AppSpacer(30.dp)
            AppButton(text = "Logout", onClick = {
                SecureSharedPreference(context).clear()
                onClose() })
        }
    }
}