package com.inspirecoding.financeup

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform