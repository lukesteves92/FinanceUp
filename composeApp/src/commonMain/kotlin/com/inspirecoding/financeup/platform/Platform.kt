package com.inspirecoding.financeup.platform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform