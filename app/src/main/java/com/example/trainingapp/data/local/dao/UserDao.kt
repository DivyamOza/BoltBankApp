package com.example.trainingapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.trainingapp.domain.models.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user_entity WHERE id = :id")
    fun getUserById(id: Int): Flow<UserEntity> // Use the `local` UserEntity
}
