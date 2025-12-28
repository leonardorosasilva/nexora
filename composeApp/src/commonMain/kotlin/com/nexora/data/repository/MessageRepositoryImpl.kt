package com.nexora.data.repository

import com.nexora.data.local.dao.MessageDao
import com.nexora.domain.model.Message
import com.nexora.domain.repository.MessageRepository
import com.nexora.data.mapper.toDomain
import com.nexora.data.mapper.toEntity

class MessageRepositoryImpl(
    private val messageDao: MessageDao
) : MessageRepository {
    override suspend fun getMessagesByMatchId(matchId: String): List<Message> {
        return messageDao.getMessagesByMatchId(matchId).map { it.toDomain() }
    }

    override suspend fun insertMessage(message: Message) {
        messageDao.insertMessage(message.toEntity())
    }

    override suspend fun updateMessage(message: Message) {
        messageDao.updateMessage(message.toEntity())
    }

    override suspend fun deleteMessage(message: Message) {
        messageDao.deleteMessage(message.toEntity())
    }
}