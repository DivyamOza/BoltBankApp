package com.example.trainingapp.presentation.screens.dashboardScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingapp.data.network.NetworkUIState
import com.example.trainingapp.domain.models.UserDetailsResponse
import com.example.trainingapp.domain.useCases.UserDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle, private val userDetailsUseCase: UserDetailsUseCase
) : ViewModel() {

    var userDetails =
        MutableStateFlow<NetworkUIState<UserDetailsResponse?>>(NetworkUIState.LOADING())

    init {
        getUserDetails("1")
    }


    private fun getUserDetails(id: String) {
        userDetails.tryEmit(NetworkUIState.LOADING())
        userDetailsUseCase(id = id).onEach {
            println("Fetched User Data: $it")
            userDetails.tryEmit(NetworkUIState.SUCCESS(it))
        }.launchIn(viewModelScope)
    }
}