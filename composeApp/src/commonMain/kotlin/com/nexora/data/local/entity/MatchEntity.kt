package com.nexora.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches")
data class MatchEntity(
    @PrimaryKey val id: String,
    val user1Id: String,
    val user2Id: String,
    val status: MatchStatusEnumEntity,
)

enum class MatchStatusEnumEntity {
    PENDENTE,
    ACEITO,
    REJEITADO,
    FINALIZADO,
}