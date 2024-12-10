package com.example.trainingapp.data.repositoryImpl

import com.example.trainingapp.data.local.dao.UserDao
import com.example.trainingapp.data.remote.UserApiInterface
import com.example.trainingapp.domain.models.UserDetailsResponse
import com.example.trainingapp.domain.models.UserEntity
import com.example.trainingapp.domain.repository.UserRepository
import retrofit2.Response
import javax.inject.Inject

/**
 * User repository impl
 *
 * @property apiInterface
 * @constructor Create empty User repository impl
 */
class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao? = null, private val apiInterface: UserApiInterface
) : UserRepository {
    override suspend fun getUserDetails(id: String): Response<UserDetailsResponse> {
        return apiInterface.getUserDetails(id = id)
    }

    override suspend fun insertUser(user: UserEntity) {
        //userDao.insertUser(user)
    }
}