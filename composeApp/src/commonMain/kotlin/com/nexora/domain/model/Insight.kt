package com.nexora.domain.model

data class Insight(
    val id: String,
    val title: String,
    val content: String,
    val tags: List<String>
)