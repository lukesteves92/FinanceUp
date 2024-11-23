package com.inspirecoding.financeup.ui.components.budget

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.inspirecoding.financeup.extensions.toPercentage
import com.inspirecoding.financeup.ui.color.BudgetProgressBarBackgroundColor
import com.inspirecoding.financeup.ui.typography.FinanceUpTypography
import com.inspirecoding.financeup.ui.typography.LTAsusFontFamily
import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_DURATION_ANIMATION_PROGRESS_MIN
import com.inspirecoding.financeup.util.constants.Constants.ProgressConstants.MAX_PROGRESS
import com.inspirecoding.financeup.util.constants.Constants.ProgressConstants.MIN_PROGRESS
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusSm
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenSmall
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenSmallMedium
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.text_budget_component_title
import financeup.composeapp.generated.resources.text_budget_component_title_over
import org.jetbrains.compose.resources.stringResource

@Composable
fun BudgetProgressBar(
    budget: String,
    spentAmount: () -> Float,
    totalBudget: () -> Float
) {
    val targetProgress = (spentAmount() / totalBudget()).coerceAtMost(MAX_PROGRESS)
    val animatedProgress = remember { mutableStateOf(MIN_PROGRESS) }

    val isOverBudget = spentAmount() > totalBudget()

    LaunchedEffect(targetProgress) {
        animatedProgress.value = targetProgress
    }

    val progress by animateFloatAsState(
        targetValue = animatedProgress.value,
        animationSpec = tween(durationMillis = KEY_DURATION_ANIMATION_PROGRESS_MIN)
    )

    Column(modifier = Modifier.padding(financeUpDimenLarge)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = financeUpDimenLarge),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                fontFamily = LTAsusFontFamily(),
                text = stringResource(Res.string.text_budget_component_title),
                style = FinanceUpTypography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = financeUpDimenLarge)
            )

            Text(
                fontFamily = LTAsusFontFamily(),
                text = budget,
                style = FinanceUpTypography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = financeUpDimenLarge)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .weight(MAX_PROGRESS)
                    .height(financeUpDimenLarge)
                    .clip(RoundedCornerShape(financeUpBorderRadiusSm)),
                color = if (isOverBudget) Color.Red else BudgetProgressBarBackgroundColor,
            )

            Spacer(modifier = Modifier.width(financeUpDimenSmallMedium))

            Text(
                fontFamily = LTAsusFontFamily(),
                text = progress.toPercentage(),
                style = FinanceUpTypography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        if (isOverBudget) {
            Text(
                text = stringResource(Res.string.text_budget_component_title_over),
                color = Color.Red,
                style = FinanceUpTypography.bodySmall,
                modifier = Modifier.padding(top = financeUpDimenSmall)
            )
        }
    }
}