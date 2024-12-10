package com.example.trainingapp.di

import android.content.Context
import androidx.room.Room
import com.example.trainingapp.core.Constants
import com.example.trainingapp.data.local.dao.UserDao
import com.example.trainingapp.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    // Provide the Room Database instance
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context, AppDatabase::class.java, Constants.DATABASE_NAME
        ).build()
    }

    // Provide the DAO instance from the Room Database
    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }
}
