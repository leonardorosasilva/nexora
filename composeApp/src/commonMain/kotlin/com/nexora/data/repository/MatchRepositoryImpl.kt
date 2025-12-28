package com.nexora.data.repository

import com.nexora.data.local.dao.MatchDao
import com.nexora.domain.model.Match
import com.nexora.domain.repository.MatchRepository
import com.nexora.data.mapper.toDomain
import com.nexora.data.mapper.toEntity

class MatchRepositoryImpl(
    private val matchDao: MatchDao
) : MatchRepository {

    override suspend fun getMatchById(id: String): Match? {
        return matchDao.getMatchById(id)?.toDomain()
    }

    override suspend fun getMatchesByUserId(userId: String): List<Match> {
        return matchDao.getMatchesByUserId(userId).map { it.toDomain() }
    }

    override suspend fun insertMatch(match: Match) {
        matchDao.insertMatch(match.toEntity())
    }

    override suspend fun updateMatch(match: Match) {
        matchDao.updateMatch(match.toEntity())
    }

    override suspend fun deleteMatch(match: Match) {
        matchDao.deleteMatch(match.toEntity())
    }
}