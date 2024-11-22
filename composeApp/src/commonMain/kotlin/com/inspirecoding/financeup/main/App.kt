package com.inspirecoding.financeup.main

import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.inspirecoding.financeup.navigation.hosts.login.LoginNavHost
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    FinanceUpTheme {
        Scaffold(
            modifier = Modifier
                .imePadding(),
            containerColor = FinanceUpTheme.colorScheme.screen.background,
            content = { paddingValues ->
                LoginNavHost(
                    modifier = Modifier
                        .padding(paddingValues),
                    navHostController = rememberNavController()
                )
            }
        )
    }
}