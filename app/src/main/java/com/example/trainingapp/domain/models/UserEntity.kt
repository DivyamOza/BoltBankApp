package com.example.trainingapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_entity") // Ensure the table name matches your DAO queries
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val email: String
)
