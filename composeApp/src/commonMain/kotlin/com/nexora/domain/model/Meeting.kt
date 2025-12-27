package com.nexora.domain.model

data class Meeting(
    val id: String,
    val match: String,
    val title: String,
    val description: String,
    val date: String,
    val status: MeetingStatusEnum,
    val participants: List<String>
)

enum class MeetingStatusEnum {
    PENDENTE,
    ACEITO,
    REJEITADO,
    FINALIZADO,
}

