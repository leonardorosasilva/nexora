import javax.inject.Inject
import com.nexora.data.local.dao.InsightDao
import com.nexora.domain.model.Insight
import com.nexora.domain.repository.InsightRepository
import com.nexora.data.mapper.toDomain
import com.nexora.data.mapper.toEntity
import com.nexora.data.mapper.InsightMapper

class InsightRepositoryImpl @Inject constructor(
    private val insightDao: InsightDao,
    private val insightMapper: InsightMapper
) : InsightRepository {
    override suspend fun getInsightById(id: String): Insight? {
        return insightDao.getInsightById(id)?.toDomain()
    }

    override suspend fun getInsightsByUserId(userId: String): List<Insight> {
        return insightDao.getInsightsByUserId(userId).map { it.toDomain() }
    }

    override suspend fun insertInsight(insight: Insight) {
        insightDao.insertInsight(insight.toEntity())
    }
    
    override suspend fun updateInsight(insight: Insight) {
        insightDao.updateInsight(insight.toEntity())
    }

    override suspend fun deleteInsight(insight: Insight) {
        insightDao.deleteInsight(insight.toEntity())
    }
}