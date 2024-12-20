package com.example.trainingapp.presentation.screens.homeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.trainingapp.domain.models.HomeQuotesDC
import com.example.trainingapp.data.network.NetworkUIState
import com.example.trainingapp.presentation.components.AppProgressBar
import com.example.trainingapp.presentation.components.ToolBarComponent
import com.example.trainingapp.presentation.screens.homeScreen.components.HomeBody

@Composable
fun HomeScreen(
    homeVM: HomeVM = hiltViewModel(),
    onClick: (id: String) -> Unit
) {

    val state = homeVM.quotesData.collectAsStateWithLifecycle().value

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            ToolBarComponent(title = "Home")
        }
    ) { paddingValue ->
        Box(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                is NetworkUIState.LOADING -> {
                    AppProgressBar()
                }

                is NetworkUIState.SUCCESS<HomeQuotesDC> -> {
                    HomeBody(state.data, onClick = onClick)
                }

                else -> Unit
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen {}
}