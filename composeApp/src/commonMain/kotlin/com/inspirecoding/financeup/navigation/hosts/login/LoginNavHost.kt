package com.inspirecoding.financeup.navigation.hosts.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.inspirecoding.financeup.features.login.email.screen.LoginEmailScreen
import com.inspirecoding.financeup.features.login.secret.screen.LoginSecretScreen
import com.inspirecoding.financeup.navigation.hosts.home.homeNavHost
import com.inspirecoding.financeup.navigation.routes.home.HomeRoutes
import com.inspirecoding.financeup.navigation.routes.login.LoginRoutes


@Composable
fun LoginNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = HomeRoutes.Graph,
        modifier = modifier
    ) {
        composable<LoginRoutes.Email> {
            LoginEmailScreen(
                navigateToLoginPasswordScreen = { email ->
                    navHostController.navigate(LoginRoutes.Secret(email))
                },
                onBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }

        composable<LoginRoutes.Secret> {
            LoginSecretScreen(
                navigateToHomeScreen = {
                    navHostController.navigate(HomeRoutes.Graph) {
                        popUpTo(0) { inclusive = true }
                        launchSingleTop = true
                    }
                },
                onBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }

        homeNavHost(navHostController = navHostController)
    }
}