package com.example.trainingapp.data.repositoryImpl

import com.example.trainingapp.data.remote.ApiInterface
import com.example.trainingapp.domain.models.AllQuotesDC
import com.example.trainingapp.domain.repository.QuoteRepository
import retrofit2.Response
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface
): QuoteRepository {

    override suspend fun getAllQuotes(): Response<AllQuotesDC> {
        return apiInterface.getAllQuotes()
    }

    override suspend fun getRandomQuote(): Response<AllQuotesDC.QuoteDC> {
        return apiInterface.getRandomQuote()
    }

    override suspend fun getSingleQuote(id: String): Response<AllQuotesDC.QuoteDC> {
        return apiInterface.getSingleQuotes(id = id)
    }
}