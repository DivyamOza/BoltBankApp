package com.example.trainingapp.presentation.screens.dashboardScreen

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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.trainingapp.data.network.NetworkUIState
import com.example.trainingapp.presentation.components.AppProgressBar
import com.example.trainingapp.presentation.screens.dashboardScreen.components.CurrentBalance
import com.example.trainingapp.presentation.screens.dashboardScreen.components.DrawerContent
import com.example.trainingapp.presentation.screens.dashboardScreen.components.TagRow
import com.example.trainingapp.presentation.screens.dashboardScreen.components.UserStatusWidget
import com.example.trainingapp.presentation.screens.dashboardScreen.pages.DashboardHomePage
import com.example.trainingapp.presentation.screens.dashboardScreen.pages.DashboardMoneyPage
import com.example.trainingapp.presentation.screens.dashboardScreen.pages.DashboardSettingPage
import com.example.trainingapp.presentation.screens.dashboardScreen.pages.DashboardWalletPage
import com.example.trainingapp.presentation.screens.dashboardScreen.pages.dashboardAddPage.DashboardAddPage
import com.example.trainingapp.presentation.screens.dashboardScreen.pages.dashboardAddPage.screens.DashboardCalendarPage
import com.example.trainingapp.presentation.screens.dashboardScreen.pages.dashboardAddPage.screens.DashboardGraphPage
import com.example.trainingapp.ui.theme.Green
import kotlinx.coroutines.launch

@Preview
@Composable
fun DashboardScreen(
    dashboardViewModel: DashboardViewModel = hiltViewModel(),
    gotoProfile: () -> Unit,
    performLogout: () -> Unit
) {
    val state = dashboardViewModel.userDetails.collectAsStateWithLifecycle().value
    var selectedTag by rememberSaveable { mutableStateOf(0) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    var isGraph by rememberSaveable { mutableStateOf(false) }
    var isCalender by rememberSaveable { mutableStateOf(false) }

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        // Drawer content
        DrawerContent(modifier = Modifier
            .fillMaxSize()
            .background(Color.White), onClose = {
            coroutineScope.launch {
                drawerState.close()
            }
        }, onLogout = {
            performLogout()
        })
    }, content = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            when (state) {
                is NetworkUIState.LOADING -> {
                    AppProgressBar()
                }

                is NetworkUIState.SUCCESS -> {
                    val userData = state.data
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .padding(bottom = 60.dp)
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
                                        imgUrl = userData?.image
                                            ?: "https://pngfre.com/wp-content/uploads/virat-kohli-poster.png",
                                        name = userData?.username ?: "",
                                        location = userData?.address?.address ?: ""
                                    )
                                    IconButton(onClick = {
                                        coroutineScope.launch {
                                            drawerState.open()
                                        }
                                    }) {
                                        Icon(
                                            imageVector = Icons.Filled.Menu,
                                            contentDescription = "User Profile",
                                            tint = Color.White,
                                        )
                                    }
                                }
                            }
                            CurrentBalance(
                                currentBalance = 15000.0
                            )
                            Box(modifier = Modifier.padding(horizontal = 15.dp)) {
                                when (selectedTag) {
                                    0 -> DashboardHomePage()
                                    1 -> DashboardWalletPage()
                                    2 -> {
                                        if (isGraph) {
                                            DashboardAddPage(onNavigate = {
                                                isGraph = false
                                                isCalender = true
                                            }, onPrevious = {
                                                isGraph = false
                                            })
                                        } else if (isCalender) {
                                            DashboardCalendarPage()
                                        } else {
                                            DashboardGraphPage(onNext = {
                                                isGraph = true
                                                isCalender = false
                                            })
                                        }
                                    }

                                    3 -> DashboardMoneyPage()
                                    4 -> DashboardSettingPage()
                                }
                            }
                        }
                    }
                    // Tag Row (Bottom)
                    TagRow(
                        selectedTag = selectedTag,
                        onTagSelected = { selectedTag = it },
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .height(60.dp)
                    )
                }

                else -> Unit
            }
        }
    })
}