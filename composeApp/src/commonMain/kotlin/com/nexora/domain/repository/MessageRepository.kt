interface MessageRepository {
    suspend fun getMessagesByMatchId(matchId: String): List<Message>
    suspend fun insertMessage(message: Message)
    suspend fun updateMessage(message: Message)
    suspend fun deleteMessage(message: Message)
}