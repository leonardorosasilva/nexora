package com.nexora.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class MessageEntity(
    @PrimaryKey val id: String,
    val matchId: String,
    val senderId: String,
    val receiverId: String,
    val text: String,
    val timestamp: Long = 0L
)
