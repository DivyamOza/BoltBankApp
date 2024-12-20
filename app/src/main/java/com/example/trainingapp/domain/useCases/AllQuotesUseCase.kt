package com.example.trainingapp.domain.useCases

import com.example.trainingapp.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AllQuotesUseCase @Inject constructor(
    private val quotesRepository: QuoteRepository
){

    operator fun invoke() = flow {
        quotesRepository.getAllQuotes().let {
            if (it.isSuccessful){
                emit(it.body()?.quotes)
            }
        }
    }

}