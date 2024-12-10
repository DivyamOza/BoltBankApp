package com.example.trainingapp.domain.repository

import com.example.trainingapp.domain.models.AllQuotesDC
import retrofit2.Response

interface QuoteRepository {

    suspend fun getAllQuotes(): Response<AllQuotesDC>

    suspend fun getRandomQuote(): Response<AllQuotesDC.QuoteDC>

    suspend fun getSingleQuote(id: String): Response<AllQuotesDC.QuoteDC>

}