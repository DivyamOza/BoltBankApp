package com.example.trainingapp.presentation.screens.dashboardScreen.components

import android.graphics.Color
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.trainingapp.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter

@Composable
fun LineChartView() {
    AndroidView(modifier = Modifier.fillMaxSize(), factory = { context ->
        LineChart(context).apply {
            setBackgroundColor(Color.WHITE)
            setDrawGridBackground(false)
            setTouchEnabled(true)

            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.granularity = 1f
            xAxis.setDrawGridLines(false)
            description.isEnabled = false
            xAxis.valueFormatter = object : ValueFormatter() {
                override fun getFormattedValue(value: Float): String {
                    val days = (1..20).map { "${context.getString(R.string.day)} $it" }
                    return days.getOrNull(value.toInt() - 1) ?: value.toString()
                }
            }

            axisLeft.setDrawGridLines(false)
            axisRight.isEnabled = false

            data = generateLineData()
            // Animation
            animateX(1500)
            animateY(400)
            invalidate()
        }
    })
}


fun generateLineData(): LineData {
    val transactionData = listOf(
        Pair(1f, 1200f),
        Pair(2f, 1400f),
        Pair(3f, 800f),
        Pair(4f, 1700f),
        Pair(5f, 2000f),
        Pair(6f, 1300f),
        Pair(7f, 1500f),
        Pair(8f, 900f),
        Pair(9f, 1100f),
        Pair(10f, 1800f),
        Pair(11f, 1600f),
        Pair(12f, 1200f),
        Pair(13f, 2100f),
        Pair(14f, 1900f),
        Pair(15f, 1000f),
        Pair(16f, 2200f),
        Pair(17f, 2400f),
        Pair(18f, 1300f),
        Pair(19f, 1800f),
        Pair(20f, 2500f)
    )

    val entries = transactionData.map { (x, y) -> Entry(x, y) }

    val dataSet = LineDataSet(entries, "Transactions").apply {
        color = Color.BLUE
        lineWidth = 2f
        setCircleColor(Color.MAGENTA)
        circleRadius = 4f
        setDrawCircleHole(false)
        valueTextColor = Color.BLACK
        valueTextSize = 1f
    }

    return LineData(dataSet)
}

