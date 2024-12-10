package com.example.trainingapp.di

import com.example.trainingapp.data.network.BASE_URL
import com.example.trainingapp.data.remote.ApiInterface
import com.example.trainingapp.data.remote.UserApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Network module
 *
 * @constructor Create empty Network module
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Get base url
     *
     * @return
     */
    @Singleton
    @Provides
    @Named("base_url")
    fun getBaseUrl(): String = BASE_URL

    /**
     * Get retrofit client
     *
     * @param baseUrl
     * @return
     */
    @Singleton
    @Provides
    fun getRetrofitClient(
        @Named("base_url") baseUrl: String
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * Get api client
     *
     * @param retrofit
     * @return
     */
    @Singleton
    @Provides
    fun getApiClient(
        retrofit: Retrofit
    ): ApiInterface = retrofit.create(ApiInterface::class.java)


    /**
     * Get api client
     *
     * @param retrofit
     * @return
     */
    @Singleton
    @Provides
    fun getUserAPIInterface(
        retrofit: Retrofit
    ): UserApiInterface = retrofit.create(UserApiInterface::class.java)


}