package com.nexora.domain.model

data class Message(
    val messageId: String,
    val matchId: String,
    val senderId: String,
    val receiverId: String,
    val text: String,
    val timestamp: Long
)
