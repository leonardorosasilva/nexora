package com.nexora.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.nexora.data.local.converters.Converters

data class User(
    @PrimaryKey val id: String,
    val name: String,
    val email: String,
    val username: String,
    val photoUrl: String? = null,
    val bio: String? = null,
    val skills: List<String>? = null,
    val goals: List<String>? = null,
    val stage: String,
    val status: StatusEnum
)

enum class StatusEnum {
    ATIVO,
    PENDENTE,
    DESATIVADO
}
