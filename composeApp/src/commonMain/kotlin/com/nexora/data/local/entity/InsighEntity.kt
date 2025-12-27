package com.nexora.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "insights")
data class InsightEntity(
    @PrimaryKey val id: String,
    val title: String,
    val content: String,
    val tags: List<String>
    val status: InsightStatusEnumEntity,
)

enum class InsightStatusEnumEntity {
    PUBLICO,
    PRIVADO,
}