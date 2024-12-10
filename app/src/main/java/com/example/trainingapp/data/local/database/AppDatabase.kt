package com.example.trainingapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.trainingapp.data.local.dao.UserDao
import com.example.trainingapp.domain.models.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}