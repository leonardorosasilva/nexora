package com.nexora.domain.model
data class Match(
    val id: String,
    val user1Id: String,
    val user2Id: String,
    val status: MatchStatusEnum,
)

enum class MatchStatusEnum {
    PENDENTE,
    ACEITO,
    REJEITADO,
    FINALIZADO,
}