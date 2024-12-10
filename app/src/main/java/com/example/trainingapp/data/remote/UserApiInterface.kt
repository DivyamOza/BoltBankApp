package com.example.trainingapp.data.remote

import com.example.trainingapp.data.network.GET_USER_DETAILS
import com.example.trainingapp.domain.models.UserDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiInterface {
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