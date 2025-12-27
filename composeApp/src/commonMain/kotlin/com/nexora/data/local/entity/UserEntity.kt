package com.nexora.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String,
    val username: String,
    val name: String,
    val email: String,
    val photoUrl: String? = null,
    val bio: String? = null,
    val skills: List<String>? = null,
    val goals: List<String>? = null,
    val stage: String,
    val status: String
)
