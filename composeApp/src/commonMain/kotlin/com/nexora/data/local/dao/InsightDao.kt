

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nexora.domain.model.Insight

@Dao
interface InsightDao {
    @Query("SELECT * FROM insights WHERE id = :id")
    suspend fun getInsightById(id: String): Insight?

    @Query("SELECT * FROM insights WHERE userId = :userId")
    suspend fun getInsightsByUserId(userId: String): List<Insight>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInsight(insight: Insight)

    @Update
    suspend fun updateInsight(insight: Insight)

    @Delete
    suspend fun deleteInsight(insight: Insight)
}