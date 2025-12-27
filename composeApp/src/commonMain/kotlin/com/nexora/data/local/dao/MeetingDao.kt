package com.nexora.data.local.dao

import com.nexora.domain.model.Meeting
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface MeetingDao {
    @Query("SELECT * FROM meetings WHERE id = :id")
    suspend fun getMeetingById(id: String): Meeting?

    @Query("SELECT * FROM meetings WHERE matchId = :matchId")
    suspend fun getMeetingsByMatchId(matchId: String): List<Meeting>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeeting(meeting: Meeting)

    @Update
    suspend fun updateMeeting(meeting: Meeting)

    @Delete
    suspend fun deleteMeeting(meeting: Meeting)

}