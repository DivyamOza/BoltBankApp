package com.example.trainingapp.presentation.screens.dashboardScreen.components

import android.graphics.Color
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.trainingapp.ui.theme.Green
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

@Composable
fun PieChart(modifier: Modifier = Modifier) {
    AndroidView(
        factory = { context ->
            PieChart(context).apply {
                val pieEntries = listOf(
                    PieEntry(100f, "Income"),
                    PieEntry(100f, "Expanses"),
                    /*PieEntry(20f, "C"),
                    PieEntry(10f, "D")*/
                )
                val dataSet = PieDataSet(pieEntries, "Pie Chart Example").apply {
                    colors = listOf(Color.RED, Color.GREEN)
                    valueTextColor = Color.WHITE
                    valueTextSize = 14f
                }

                data = PieData(dataSet)
                description.isEnabled = false
                setUsePercentValues(true)
                invalidate() // Refresh the chart
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight() // Ensure the chart takes up all available space
    )
}

