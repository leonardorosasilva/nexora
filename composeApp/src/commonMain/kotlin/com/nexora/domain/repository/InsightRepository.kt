package com.nexora.domain.repository

import com.nexora.domain.model.Insight

interface InsightRepository {
    suspend fun getInsightById(id: String): Insight?
    suspend fun getAllInsights(): List<Insight>
    suspend fun insertInsight(insight: Insight)
    suspend fun updateInsight(insight: Insight)
    suspend fun deleteInsight(insight: Insight)
}