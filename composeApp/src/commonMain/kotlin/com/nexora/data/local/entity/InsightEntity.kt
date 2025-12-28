package com.nexora.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.nexora.data.local.converters.Converters

@Entity(tableName = "insights")
@TypeConverters(Converters::class)
data class InsightEntity(
    @PrimaryKey val id: String,
    val title: String,
    val content: String,
    val tags: List<String>,
    val status: String
)