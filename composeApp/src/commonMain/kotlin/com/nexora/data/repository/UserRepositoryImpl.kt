package com.nexora.data.repository

import com.nexora.data.local.dao.UserDao
import com.nexora.domain.model.User
import com.nexora.domain.repository.UserRepository
import com.nexora.data.mapper.toDomain
import com.nexora.data.mapper.toEntity

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {

    override suspend fun getUserById(id: String): User? {
        return userDao.getUserById(id)?.toDomain()
    }

    override suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)?.toDomain()
    }

    override suspend fun insertUser(user: User) {
        userDao.insertUser(user.toEntity())
    }
}