package com.nexora.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.nexora.data.local.converters.Converters

@Entity(tableName = "meetings")
@TypeConverters(Converters::class)
data class MeetingEntity(
    @PrimaryKey val id: String,
    val matchId: String,
    val title: String,
    val description: String,
    val date: String,
    val status: String,
    val participants: List<String>
)

enum class MeetingStatusEnumEntity {
    PENDENTE,
    ACEITO,
    REJEITADO,
    FINALIZADO,
}


