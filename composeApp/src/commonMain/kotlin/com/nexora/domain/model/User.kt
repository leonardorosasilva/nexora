package com.nexora.domain.model

data class User(
    val id: String,
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
