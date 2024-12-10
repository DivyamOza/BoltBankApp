package com.example.trainingapp.domain.repository

import com.example.trainingapp.domain.models.UserDetailsResponse
import com.example.trainingapp.domain.models.UserEntity
import retrofit2.Response

interface UserRepository {
    suspend fun getUserDetails(id: String): Response<UserDetailsResponse>
    suspend fun insertUser(user: UserEntity)
}