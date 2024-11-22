package com.inspirecoding.financeup.navigation.routes.home

import kotlinx.serialization.Serializable

sealed interface HomeRoutes {

    @Serializable
    data object Graph: HomeRoutes

    @Serializable
    data object Home : HomeRoutes
}