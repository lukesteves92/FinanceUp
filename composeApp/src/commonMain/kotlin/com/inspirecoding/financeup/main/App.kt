package com.inspirecoding.financeup.main

import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
            content = { paddingValues -> }
        )
    }
}