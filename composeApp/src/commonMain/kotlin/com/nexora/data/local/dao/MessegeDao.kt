package com.nexora.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nexora.domain.model.Message

@Dao
interface MessageDao {

    @Query("SELECT * FROM messages m LEFT JOIN users u ON m.senderId = u.id WHERE m.matchId = :matchId")
    suspend fun getMessagesByMatchId(matchId: String): List<Message>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: Message)

    @Update
    suspend fun updateMessage(message: Message)

    @Delete
    suspend fun deleteMessage(message: Message)
}