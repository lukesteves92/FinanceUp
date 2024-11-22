package com.inspirecoding.financeup.navigation.routes

import kotlinx.serialization.Serializable

sealed interface LoginRoutes {

    @Serializable
    data object Email: LoginRoutes

    @Serializable
    data class Secret(val email: String): LoginRoutes

}