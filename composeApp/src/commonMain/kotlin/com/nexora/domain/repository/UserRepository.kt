package com.nexora.domain.repository

import com.nexora.domain.model.User

interface UserRepository {
    suspend fun getUserById(id: String): User?
    suspend fun getUserByEmail(email: String): User?
    suspend fun insertUser(user: User)
}