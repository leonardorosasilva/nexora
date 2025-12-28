package com.nexora.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nexora.data.local.entity.InsightEntity

@Dao
interface InsightDao {
    @Query("SELECT * FROM insights WHERE id = :id")
    suspend fun getInsightById(id: String): InsightEntity?

    @Query("SELECT * FROM insights")
    suspend fun getAllInsights(): List<InsightEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInsight(insight: InsightEntity)

    @Update
    suspend fun updateInsight(insight: InsightEntity)

    @Delete
    suspend fun deleteInsight(insight: InsightEntity)
}