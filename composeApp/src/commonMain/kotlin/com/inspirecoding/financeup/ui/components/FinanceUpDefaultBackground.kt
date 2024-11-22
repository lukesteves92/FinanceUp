package com.inspirecoding.financeup.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.inspirecoding.financeup.ui.color.ScreenBackgroundColorWhite
import com.inspirecoding.financeup.ui.color.ScreenBackgroundColorYellow
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.util.Variables.helloOpacity90Percent

@Composable
fun FinanceUpDefaultBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        ScreenBackgroundColorYellow.copy(alpha = helloOpacity90Percent),
                        ScreenBackgroundColorWhite.copy(alpha = helloOpacity90Percent)
                    )
                )
            )
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        FinanceUpTheme.colorScheme.screen.background,
                        FinanceUpTheme.colorScheme.screen.background.copy(alpha = helloOpacity90Percent),
                        FinanceUpTheme.colorScheme.screen.background
                    )
                )
            )
    )
}