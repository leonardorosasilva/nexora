

import com.nexora.domain.model.Match

interface MatchRepository {
    suspend fun getMatchById(id: String): Match?
    suspend fun getMatchesByUserId(userId: String): List<Match>
    suspend fun insertMatch(match: Match)
    suspend fun updateMatch(match: Match)
    suspend fun deleteMatch(match: Match)
}