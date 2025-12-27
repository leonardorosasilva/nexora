import javax.inject.Inject
import com.nexora.data.local.dao.MeetingDao
import com.nexora.domain.model.Meeting
import com.nexora.domain.repository.MeetingRepository
import com.nexora.data.mapper.toDomain
import com.nexora.data.mapper.toEntity
import com.nexora.data.mapper.MeetingMapper


class MeetingRepositoryImpl @Inject constructor(
    private val meetingDao: MeetingDao,
    private val meetingMapper: MeetingMapper
) : MeetingRepository {
    override suspend fun getMeetingById(id: String): Meeting? {
        return meetingDao.getMeetingById(id)?.toDomain()
    }

    override suspend fun getMeetingsByMatchId(matchId: String): List<Meeting> {
        return meetingDao.getMeetingsByMatchId(matchId).map { it.toDomain() }
    }

    override suspend fun insertMeeting(meeting: Meeting) {
        meetingDao.insertMeeting(meeting.toEntity())
    }
    
    override suspend fun updateMeeting(meeting: Meeting) {
        meetingDao.updateMeeting(meeting.toEntity())
    }

    override suspend fun deleteMeeting(meeting: Meeting) {
        meetingDao.deleteMeeting(meeting.toEntity())
    }
}