package com.inspirecoding.financeup.ui.components.income.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.inspirecoding.financeup.extensions.formatCurrency
import com.inspirecoding.financeup.model.IncomeItem
import com.inspirecoding.financeup.ui.color.FinanceUpColorBaselineWhite
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.ui.typography.FinanceUpTypography
import com.inspirecoding.financeup.ui.typography.LTAsusFontFamily
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusLg
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimen3XLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenExtraWideM
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpOpacity70Percent
import com.inspirecoding.financeup.util.variables.Variables.financeUpOpacity90Percent

@Composable
fun IncomeCard(
    incomeItem: IncomeItem,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .size(financeUpDimenExtraWideM)
            .clip(RoundedCornerShape(financeUpBorderRadiusLg)),
        colors = CardDefaults.elevatedCardColors(containerColor = FinanceUpTheme.colorScheme.screen.background.copy(alpha = financeUpOpacity90Percent))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(financeUpDimenLarge),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = incomeItem.type.icon,
                contentDescription = incomeItem.name,
                modifier = Modifier.size(financeUpDimen3XLarge),
                tint = FinanceUpColorBaselineWhite
            )

            Text(
                fontFamily = LTAsusFontFamily(),
                text = incomeItem.name,
                style = FinanceUpTypography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = incomeItem.amount.formatCurrency(),
                style = FinanceUpTypography.titleMedium,
                fontFamily = LTAsusFontFamily(),
            )

            Text(
                text = incomeItem.receivedDate,
                style = FinanceUpTypography.titleMedium,
                fontFamily = LTAsusFontFamily(),
                color = FinanceUpColorBaselineWhite.copy(alpha = financeUpOpacity70Percent)
            )
        }
    }
}