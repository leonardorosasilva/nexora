interface InsightRepository {
    suspend fun getInsightById(id: String): Insight?
    suspend fun getInsightsByUserId(userId: String): List<Insight>
    suspend fun insertInsight(insight: Insight)
    suspend fun updateInsight(insight: Insight)
    suspend fun deleteInsight(insight: Insight)
}