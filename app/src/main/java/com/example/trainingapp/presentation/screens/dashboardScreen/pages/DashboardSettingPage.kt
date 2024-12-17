package com.example.trainingapp.presentation.screens.dashboardScreen.pages

import AppSwitch
import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trainingapp.R
import com.example.trainingapp.utils.CommonUtils.setLocale
import java.util.Locale

@Preview
@Composable
fun DashboardSettingPage() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        SettingsScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    var currentLanguage by remember { mutableStateOf(Locale.getDefault().displayLanguage) }
    val context = LocalContext.current

    Scaffold(
        containerColor = Color.White
    ) { paddingValues -> // Use the paddingValues parameter here
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Apply padding from Scaffold
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = context.getString(R.string.general),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            SettingsRow(title = context.getString(R.string.notifications),
                description = context.getString(R.string.notifications_subtitle),
                hasToggle = true,
                isChecked = true,
                onToggleChange = {})
            SettingsRow(title = context.getString(R.string.dark_mode),
                description = context.getString(R.string.dark_mode_subtitle),
                hasToggle = true,
                isChecked = false,
                onToggleChange = {})

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = context.getString(R.string.account),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            SettingsRow(title = context.getString(R.string.change_password),
                description = context.getString(R.string.change_password_subtitle),
                hasToggle = false,
                onClick = { /* Navigate to change password screen */ })
            SettingsRow(title = context.getString(R.string.language),
                description = context.getString(R.string.language_subtitle),
                hasDropDown = true,
                dropDownOptions = listOf("English", "French"),
                selectedOption = currentLanguage,
                onOptionSelected = {
                    println("LANGUAGE NAME: $it")
                    if (it.equals("french", true)) {
                        currentLanguage = Locale("fr").displayLanguage
                        context.setLocale(
                            locale = Locale("fr")
                        )
                    } else {
                        currentLanguage = Locale("en").displayLanguage
                        context.setLocale(
                            locale = Locale("en")
                        )
                    }
                    // Recreate the activity to apply changes
                    (context as? Activity)?.recreate()
                })
        }
    }
}

@Composable
fun SettingsRow(
    title: String,
    description: String,
    hasToggle: Boolean = false,
    isChecked: Boolean = false,
    onToggleChange: (Boolean) -> Unit = {},
    hasDropDown: Boolean = false,
    dropDownOptions: List<String> = emptyList(),
    selectedOption: String = "",
    onOptionSelected: (String) -> Unit = {},
    onClick: () -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }

    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { if (!hasToggle && !hasDropDown) onClick() }
        .padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, style = MaterialTheme.typography.bodyMedium)
            Text(
                text = description, style = MaterialTheme.typography.bodySmall, color = Color.Gray
            )
        }
        if (hasToggle) {
            AppSwitch(
                isChecked = rememberSaveable { mutableStateOf(isChecked) },
                onCheckedChange = { onToggleChange(it) },
            )
        }
        if (hasDropDown) {
            Box {
                Text(text = selectedOption,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .clickable { expanded = true }
                        .padding(horizontal = 8.dp))
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    containerColor = Color.White,
                ) {
                    // Create a DropdownMenuItem for each option
                    dropDownOptions.forEach { option ->
                        if (!option.isNullOrEmpty()) { // Ensure the option is valid
                            DropdownMenuItem(onClick = {
                                expanded = false
                                onOptionSelected(option)
                            }, text = { Text(text = option) })
                        }
                    }
                }
            }
        }
    }
}
