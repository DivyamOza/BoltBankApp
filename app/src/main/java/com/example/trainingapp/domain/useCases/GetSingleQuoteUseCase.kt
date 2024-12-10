package com.example.trainingapp.domain.useCases

import com.example.trainingapp.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSingleQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {

    operator fun invoke(id: String) = flow {
        quoteRepository.getSingleQuote(id = id).let {
            if (it.isSuccessful){
                emit(it.body())
            }
        }
    }

}