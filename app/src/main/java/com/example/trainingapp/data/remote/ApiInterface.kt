package com.example.trainingapp.data.remote

import com.example.trainingapp.data.network.ALL_QUOTES
import com.example.trainingapp.data.network.GET_SINGLE_QUOTE
import com.example.trainingapp.data.network.GET_USER_DETAILS
import com.example.trainingapp.data.network.RANDOM_QUOTE
import com.example.trainingapp.domain.models.AllQuotesDC
import com.example.trainingapp.domain.models.UserDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Api interface
 *
 * @constructor Create empty Api interface
 */
interface ApiInterface {
    /**
     * Get all quotes
     *
     * @return
     */
    @GET(ALL_QUOTES)
    suspend fun getAllQuotes(): Response<AllQuotesDC>

    /**
     * Get random quote
     *
     * @return
     */
    @GET(RANDOM_QUOTE)
    suspend fun getRandomQuote(): Response<AllQuotesDC.QuoteDC>

    /**
     * Get single quotes
     *
     * @param id
     * @return
     */
    @GET(GET_SINGLE_QUOTE)
    suspend fun getSingleQuotes(
        @Path("id") id: String
    ): Response<AllQuotesDC.QuoteDC>


    /**
     * Get user details
     *
     * @param id
     * @return
     */
    @GET(GET_USER_DETAILS)
    suspend fun getUserDetails(
        @Path("id") id: String
    ): Response<UserDetailsResponse>

}