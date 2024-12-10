package com.example.trainingapp.di

import com.example.trainingapp.data.remote.ApiInterface
import com.example.trainingapp.data.remote.UserApiInterface
import com.example.trainingapp.data.repositoryImpl.QuoteRepositoryImpl
import com.example.trainingapp.data.repositoryImpl.UserRepositoryImpl
import com.example.trainingapp.domain.repository.QuoteRepository
import com.example.trainingapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Repository module
 *
 * @constructor Create empty Repository module
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun getQuotesRepository(
        apiInterface: ApiInterface
    ): QuoteRepository = QuoteRepositoryImpl(apiInterface = apiInterface)

    @Singleton
    @Provides
    fun getUserRepository(
        apiInterface: UserApiInterface
    ): UserRepository = UserRepositoryImpl(
        apiInterface = apiInterface,
    )
}