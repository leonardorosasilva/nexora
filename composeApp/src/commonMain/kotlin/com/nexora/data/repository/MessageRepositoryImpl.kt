import javax.inject.Inject
import com.nexora.data.local.dao.MessageDao
import com.nexora.domain.model.Message
import com.nexora.data.mapper.toDomain
import com.nexora.data.mapper.toEntity
import com.nexora.data.mapper.MessageMapper

class MessageRepositoryImpl @Inject constructor(
    private val messageDao: MessageDao,
    private val messageMapper: MessageMapper
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