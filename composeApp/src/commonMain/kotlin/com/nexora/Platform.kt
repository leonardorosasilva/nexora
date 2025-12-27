package com.nexora

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform