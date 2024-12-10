package com.example.trainingapp.presentation.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingapp.domain.models.AllQuotesDC
import com.example.trainingapp.domain.models.HomeQuotesDC
import com.example.trainingapp.domain.useCases.AllQuotesUseCase
import com.example.trainingapp.domain.useCases.RandomQuoteUseCase
import com.example.trainingapp.data.network.NetworkUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val allQuotesUseCase: AllQuotesUseCase,
    private val randomQuoteUseCase: RandomQuoteUseCase
) : ViewModel() {


    var quotesData = MutableStateFlow<NetworkUIState<HomeQuotesDC>>(NetworkUIState.LOADING())
        private set


    init {
        getQuotes()
    }


    private fun getQuotes() {
        quotesData.tryEmit(NetworkUIState.LOADING())
        allQuotesUseCase().combine(randomQuoteUseCase()) { quotesList: List<AllQuotesDC.QuoteDC>?, randomQuote: AllQuotesDC.QuoteDC? ->
            quotesData.tryEmit(
                NetworkUIState.SUCCESS(
                    HomeQuotesDC(
                        randomQuote = randomQuote,
                        allQuotesList = quotesList
                    )
                )
            )
        }.launchIn(viewModelScope)
    }

}