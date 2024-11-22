package com.inspirecoding.financeup.navigation.hosts.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.inspirecoding.financeup.features.home.HomeScreen
import com.inspirecoding.financeup.navigation.routes.home.HomeRoutes

fun NavGraphBuilder.homeNavHost(
    navHostController: NavHostController
) {
    navigation<HomeRoutes.Graph>(
        startDestination = HomeRoutes.Home
    ) {
        composable<HomeRoutes.Home> {
            HomeScreen()
        }
    }
}