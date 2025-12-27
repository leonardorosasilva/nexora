interface MeetingRepository {
    suspend fun getMeetingById(id: String): Meeting?
    suspend fun getMeetingsByMatchId(matchId: String): List<Meeting>
    suspend fun insertMeeting(meeting: Meeting)
    suspend fun updateMeeting(meeting: Meeting)
    suspend fun deleteMeeting(meeting: Meeting)
}