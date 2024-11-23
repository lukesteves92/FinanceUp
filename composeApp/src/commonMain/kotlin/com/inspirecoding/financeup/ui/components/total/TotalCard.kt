package com.inspirecoding.financeup.ui.components.total

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.inspirecoding.financeup.extensions.formatCurrency
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.ui.typography.FinanceUpTypography
import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_DURATION_ANIMATION_PROGRESS_MIN
import com.inspirecoding.financeup.util.constants.Constants.ProgressConstants.MIN_PROGRESS
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusMd
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenExtraWideM
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenSmallMedium
import com.inspirecoding.financeup.util.variables.Variables.financeUpOpacity90Percent

@Composable
fun TotalCard(
    title: String,
    amountProvider: () -> Float,
    cardColor: Color,
    modifier: Modifier = Modifier
) {
    val targetAmount = amountProvider()
    val animatedAmount = remember { mutableStateOf(MIN_PROGRESS) }

    LaunchedEffect(targetAmount) {
        animatedAmount.value = MIN_PROGRESS
        animatedAmount.value = targetAmount
    }

    val displayAmount by animateFloatAsState(
        targetValue = animatedAmount.value,
        animationSpec = tween(durationMillis = KEY_DURATION_ANIMATION_PROGRESS_MIN)
    )

    Card(
        modifier = modifier.height(financeUpDimenExtraWideM),
        elevation = CardDefaults.cardElevation(defaultElevation = financeUpDimenSmallMedium),
        shape = RoundedCornerShape(financeUpBorderRadiusMd),
        colors = CardDefaults.cardColors(containerColor = FinanceUpTheme.colorScheme.screen.background.copy(alpha = financeUpOpacity90Percent))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(financeUpDimenLarge),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                style = FinanceUpTypography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = displayAmount.formatCurrency(),
                style = FinanceUpTypography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = cardColor
            )
        }
    }
}