package com.example.trainingapp.presentation.screens.dashboardScreen.pages.dashboardAddPage.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainingapp.R
import com.example.trainingapp.presentation.components.AppButton
import com.example.trainingapp.presentation.components.AppSpacer
import com.example.trainingapp.presentation.components.AppText
import com.example.trainingapp.presentation.screens.dashboardScreen.components.LineChartView
import com.example.trainingapp.ui.theme.DarkerGreen
import com.example.trainingapp.ui.theme.LightGreenForBalance

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun DashboardGraphPage() {
    val ctx = LocalContext.current
    val cardList = listOf(
        Pair(
            "Platinum Card",
            "Higher withdrawal and transaction limits.\nExclusive offers and privileges.\nEnhanced benefits on travel, dining, and shopping."
        ),
        Pair(
            "Gold Card",
            "Suitable for higher spending needs.\nCompetitive transaction limits compared to premium cards."
        ),
        Pair(
            "Wealth Card",
            "Exclusive to Wealth Management customers.\nPremium rewards and lifestyle privileges.\nHigher insurance coverage."
        ),
        Pair(
            "Pride Card", "Accepted worldwide.\nModerate transaction and withdrawal limits."
        ),
        Pair(
            "Classic Card",
            "Standard card for day-to-day transactions.\nAffordable issuance and maintenance fees."
        ),
    )

    var selectedIndex by remember { mutableStateOf(-1) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White) // Light background color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Box(modifier = Modifier.height(150.dp)) {
                LineChartView()
            }

            AppSpacer(height = 20.dp)
            AppText(text = "Card Types", isBold = true, fontSize = 20, color = Color.Black)
            AppText(
                text = "Please select any one card...",
                isThin = true,
                fontSize = 12,
                color = Color.Gray
            )

            AppSpacer(height = 10.dp)

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2.5f), // This will take all available space above the button
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                itemsIndexed(cardList) { index, item ->
                    CompactCardWithFixedHeight(pair = item, {
                        selectedIndex = index
                    }, selectedIndex == index)
                }
            }

            // Spacer to push the button to the bottom
            Spacer(modifier = Modifier.weight(1f))

            // Button at the bottom
            AppButton(
                text = stringResource(id = R.string.next).toUpperCase(Locale.current),
                backgroundColor = if (selectedIndex != -1) Color.Black else Color.Gray,
                onClick = {
                    if (selectedIndex == -1) {
                        // Please select one card option usign snack bar
                        Toast.makeText(ctx, "Please select card option", Toast.LENGTH_SHORT).show()
                    } else {
                        // Navigate
                    }
                },
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }
}


@Composable
fun CompactCardWithFixedHeight(
    pair: Pair<String, String>, onSelect: () -> Unit, isSelected: Boolean = false
) {
    // State for controlling tooltip visibility
    var isDialogVisible by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 8.dp)
            .clickable { onSelect() },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, DarkerGreen),
        colors = CardDefaults.cardColors().copy(
            containerColor = if (isSelected) LightGreenForBalance else Color.White
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = pair.first, style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium, fontSize = 14.sp
                ), color = Color.Black
            )
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Info",
                modifier = Modifier
                    .size(16.dp)
                    .clickable {
                        // Show the dialog when the info icon is clicked
                        isDialogVisible = true
                    },
                tint = Color.Gray
            )
        }
    }

    // Show dialog when isDialogVisible is true
    if (isDialogVisible) {
        DialogContent(content = pair.second) {
            // Dismiss the dialog when the close icon is clicked
            isDialogVisible = false
        }
    }
}

@Composable
fun DialogContent(content: String, onClose: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black.copy(alpha = 0.4f)) // Dark background to overlay content
        .padding(16.dp)
        .clickable { /* Prevent clicking outside dialog to dismiss */ }) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .background(Color.White, RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                onClose() // Close the dialog
                            },
                        tint = Color.Gray
                    )
                }
                Text(
                    text = content,
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
                    color = Color.Black
                )
            }
        }
    }
}
