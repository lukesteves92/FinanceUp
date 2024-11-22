package com.inspirecoding.financeup.navigation.hosts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.inspirecoding.financeup.features.login.email.screen.LoginEmailScreen
import com.inspirecoding.financeup.navigation.routes.LoginRoutes


@Composable
fun LoginNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = LoginRoutes.Email,
        modifier = modifier
    ) {
        composable<LoginRoutes.Email> {
            LoginEmailScreen(
                navigateToLoginPasswordScreen = { email -> },
                onBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }

        composable<LoginRoutes.Secret> {}
    }
}