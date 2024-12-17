package com.example.trainingapp.presentation.screens.dashboardScreen.pages.dashboardAddPage.screens

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainingapp.presentation.components.AppSpacer
import java.util.Calendar

@Preview
@Composable
fun DashboardCalendarPage() {
    // Fetching the Local Context
    val mContext = LocalContext.current

    // Initializing a Calendar instance
    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    val mYear = mCalendar.get(Calendar.YEAR)
    val mMonth = mCalendar.get(Calendar.MONTH)
    val mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    // State to store the selected date
    val mDate = remember { mutableStateOf("No date selected") }

    // Declaring DatePickerDialog and setting
    // initial values as current values
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            mDate.value = "$dayOfMonth/${month + 1}/$year"
        },
        mYear,
        mMonth,
        mDay
    )

    // UI
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display the selected date
            Text(
                text = "Selected Date: ${mDate.value}",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )

            // Spacer for better layout
            AppSpacer(height = 32.dp)

            // Button to show DatePickerDialog
            Button(onClick = { mDatePickerDialog.show() }) {
                Text(text = "Select Date")
            }
        }
    }
}
