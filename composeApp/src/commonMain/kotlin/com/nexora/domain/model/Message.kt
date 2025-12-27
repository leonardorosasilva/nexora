package com.nexora.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message(
    @PrimaryKey val messageId: String,
    val matchId: String,
    val senderId: String,
    val receiverId: String,
    val text: String,
    val timestamp: Long
)
