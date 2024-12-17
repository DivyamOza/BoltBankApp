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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextOverflow
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
import com.example.trainingapp.ui.theme.Green
import com.example.trainingapp.ui.theme.LightGreenForBalance

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DashboardGraphPage(onNext: () -> Unit) {
    val ctx = LocalContext.current
    val cardList = listOf(
        Pair(
            ctx.getString(R.string.platinum_card),
            ctx.getString(R.string.platinum_card_description)
        ),
        Pair(
            ctx.getString(R.string.gold_card),
            ctx.getString(R.string.gold_card_description),
        ),
        Pair(
            ctx.getString(R.string.wealth_card),
            ctx.getString(R.string.wealth_card_description),
        ),
        Pair(
            ctx.getString(R.string.pride_card),
            ctx.getString(R.string.pride_card_description),
        ),
        Pair(
            ctx.getString(R.string.classic_card),
            ctx.getString(R.string.classic_card_description),
        ),
    )

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

    var selectedIndex by remember { mutableStateOf(-1) }
    var selectedIndexOfInfo by remember { mutableStateOf(-1) }
    var isBottomSheetVisible by remember { mutableStateOf(false) }

    // LaunchedEffect to control modal visibility
    LaunchedEffect(isBottomSheetVisible) {
        if (isBottomSheetVisible) {
            sheetState.show() // Show the sheet when visibility is true
        } else {
            sheetState.hide() // Hide the sheet when visibility is false
        }
    }

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
            AppText(
                text = ctx.getString(R.string.card_type),
                isBold = true,
                fontSize = 20,
                color = Color.Black
            )
            AppText(
                text = ctx.getString(R.string.card_type_subtitle),
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
                    }, selectedIndex == index, onInfoClick = {
                        selectedIndexOfInfo = index
                        isBottomSheetVisible = true
                    })
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
                        // Show a toast if no card is selected
                        Toast.makeText(ctx, "Please select card option", Toast.LENGTH_SHORT).show()
                    } else {
                        // Proceed to the next screen or action
                        onNext()
                    }
                },
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }

    // Only show the bottom sheet if a valid card has been selected
    if (selectedIndexOfInfo != -1 && isBottomSheetVisible) {
        BottomSheetContent(title = cardList[selectedIndexOfInfo].first,
            content = cardList[selectedIndexOfInfo].second,
            onClose = {
                isBottomSheetVisible = false
            })
    }
}


@Composable
fun CompactCardWithFixedHeight(
    pair: Pair<String, String>,
    onSelect: () -> Unit,
    isSelected: Boolean = false,
    onInfoClick: () -> Unit
) {
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
                    fontWeight = FontWeight.Medium, fontSize = 14.sp,
                ), color = Color.Black, maxLines = 2, overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Info",
                modifier = Modifier
                    .size(16.dp)
                    .clickable { onInfoClick() },
                tint = Color.Gray
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetContent(title: String, content: String, onClose: () -> Unit) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false // Ensures that the sheet cannot be partially expanded
    )

    ModalBottomSheet(
        onDismissRequest = { onClose() },
        sheetState = sheetState,
        containerColor = Color.White,
        contentColor = Color.Black,
    ) {
        val listOfString: MutableList<String> = mutableListOf()
        val splitContent = content.split("\n")
        listOfString.addAll(splitContent)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp), horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppText(text = title, isBold = true, color = Green, fontSize = 20)
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { onClose() },
                    tint = Color.Red
                )
            }

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                listOfString.forEach { item ->
                    Text(
                        text = buildAnnotatedString {
                            append("• ") // Bullet character
                            append(item)
                        }, style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp, lineHeight = 24.sp
                        ), color = Color.Black, modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}
