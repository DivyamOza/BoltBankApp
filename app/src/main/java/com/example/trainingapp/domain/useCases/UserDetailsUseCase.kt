package com.example.trainingapp.domain.useCases

import com.example.trainingapp.domain.models.UserEntity
import com.example.trainingapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserDetailsUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(id: String) = flow {
        userRepository.getUserDetails(id = id).let {
            if (it.isSuccessful) {
                emit(it.body())
            }
        }
    }

    //operator fun invoke(id: Int): Flow<UserEntity> = userRepository.getUserById(id)

}