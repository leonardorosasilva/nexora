class MatchRepositoryImpl @Inject constructor(
    private val matchDao: MatchDao,
    private val matchMapper: MatchMapper
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
}