package com.example.trainingapp.presentation.screens.dashboardScreen.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.trainingapp.R
import com.example.trainingapp.presentation.components.AppSpacer
import com.example.trainingapp.presentation.components.AppText
import com.example.trainingapp.presentation.screens.dashboardScreen.components.CircularProgressBar
import com.example.trainingapp.ui.theme.DarkGreen
import com.example.trainingapp.ui.theme.Green
import com.example.trainingapp.ui.theme.LightYellow
import com.example.trainingapp.ui.theme.Yellow

@Composable
fun DashboardHomePage() {
    val ctx = LocalContext.current
    val tabs = ctx.run {
        listOf(
            getString(R.string.today),
            getString(R.string.month),
            getString(R.string.year),
            getString(R.string.overall)
        )
    }
    var selectedTabIndex by rememberSaveable { mutableStateOf(0) }

    // Define a map for the percentages and labels based on tab selection
    val progressData = mapOf(
        0 to Pair(0.64f, "Today"),
        1 to Pair(0.48f, "Month"),
        2 to Pair(0.72f, "Year"),
        3 to Pair(0.85f, "Overall")
    )
    val trasactionData = mapOf(
        0 to Pair("50,000", "34,000"),
        1 to Pair("50,000", "32,000"),
        2 to Pair("50,000", "36,000"),
        3 to Pair("50,000", "42,500")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 15.dp)
            .background(color = Color.White)
    ) {
        Column {
            TabRow(containerColor = Color.White,
                selectedTabIndex = selectedTabIndex,
                divider = { AppSpacer(height = 5.dp) },
                modifier = Modifier
                    .fillMaxWidth()
                    //.wrapContentHeight()
                    .background(color = Color.White),
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[selectedTabIndex])
                            .padding(horizontal = 10.dp), color = DarkGreen, height = 1.dp
                    )
                }) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        selectedContentColor = Green,
                        unselectedContentColor = Color.Gray,
                    ) {
                        AppText(
                            text = title,
                            color = if (selectedTabIndex == index) Green else Color.Gray,
                            fontSize = 18,
                            isBold = true
                        )
                    }
                }
            }
            AppSpacer(height = 50.dp)
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                CircularProgressBar(
                    percentage = progressData[selectedTabIndex]?.first ?: 0f,
                    displayText = ctx.getString(R.string.expanses),
                    progressColor = Yellow,
                    backgroundColor = LightYellow,
                    size = 170f
                )
            }
            AppSpacer(height = 40.dp)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(5.dp),
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                ) {
                    // "Income" Column
                    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.weight(1f)) {
                        AppText(
                            text = ctx.getString(R.string.income),
                            color = Color.Black,
                            fontSize = 16,
                            isBold = false
                        )
                        AppSpacer(height = 5.dp)
                        AppText(
                            text = "₹50,000",
                            color = Green,
                            fontSize = 18,
                            isBold = false,
                            isThin = true
                        )
                    }

                    // Vertical Divider in the middle
                    Box(
                        modifier = Modifier
                            .height(48.dp) // Constrain the height of the box to match the content
                            .padding(horizontal = 15.dp)
                    ) {
                        VerticalDivider(
                            modifier = Modifier
                                .fillMaxHeight() // Fills the height of the Box
                                .width(1.dp), color = Color.LightGray
                        )
                    }

                    // "Expenses" Column
                    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.weight(1f)) {
                        AppText(
                            text = ctx.getString(R.string.expanses),
                            color = Color.Black,
                            fontSize = 16,
                            isBold = false
                        )
                        AppSpacer(height = 2.dp)
                        AppText(
                            text = (trasactionData[selectedTabIndex]?.second ?: 0f).toString(),
                            color = Color.Red,
                            fontSize = 18,
                            isBold = false,
                            isThin = true
                        )
                    }
                }
            }
        }
    }
}