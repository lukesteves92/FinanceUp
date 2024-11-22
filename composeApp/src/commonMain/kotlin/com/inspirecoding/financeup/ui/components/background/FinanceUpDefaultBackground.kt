package com.inspirecoding.financeup.ui.components.background

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.inspirecoding.financeup.ui.color.ScreenBackgroundColorWhite
import com.inspirecoding.financeup.ui.color.ScreenBackgroundColorYellow
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.util.Variables.financeUpOpacity90Percent

@Composable
fun FinanceUpDefaultBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        ScreenBackgroundColorYellow.copy(alpha = financeUpOpacity90Percent),
                        ScreenBackgroundColorWhite.copy(alpha = financeUpOpacity90Percent)
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
                        FinanceUpTheme.colorScheme.screen.background.copy(alpha = financeUpOpacity90Percent),
                        FinanceUpTheme.colorScheme.screen.background
                    )
                )
            )
    )
}