package com.inspirecoding.financeup.ui.components.button

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusMicro
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimen2XLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimen5XLarge
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.finance_up_ic_arrow_right
import financeup.composeapp.generated.resources.finance_up_ic_confirm
import org.jetbrains.compose.resources.painterResource

@Composable
fun FloatingButtonUI(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    enabled: Boolean = true,
    isConfirm: Boolean = false,
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = { if (enabled) onClick() },
        modifier = modifier
            .size(financeUpDimen5XLarge),
        shape = CircleShape,
        containerColor = if (isLoading) {
            FinanceUpTheme.colorScheme.floatingButton.loading
        } else FinanceUpTheme.colorScheme.floatingButton.container,
        content = {
            when {
                isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(financeUpDimen2XLarge),
                        color = FinanceUpTheme.colorScheme.floatingButton.content,
                        strokeWidth = financeUpBorderRadiusMicro
                    )
                }

                isConfirm -> {
                    Icon(
                        painter = painterResource(Res.drawable.finance_up_ic_confirm),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }

                else -> {
                    Icon(
                        painter = painterResource(Res.drawable.finance_up_ic_arrow_right),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }
        }
    )
}