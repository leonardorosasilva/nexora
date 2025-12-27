package com.nexora.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nexora.domain.model.Match

@Dao
interface MatchDao {
    @Query("SELECT * FROM matches WHERE id = :id")
    suspend fun getMatchById(id: String): Match?

    @Query("SELECT * FROM matches WHERE userId = :userId")
    suspend fun getMatchesByUserId(userId: String): List<Match>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatch(match: Match)

    @Update
    suspend fun updateMatch(match: Match)

    @Delete
    suspend fun deleteMatch(match: Match)
}