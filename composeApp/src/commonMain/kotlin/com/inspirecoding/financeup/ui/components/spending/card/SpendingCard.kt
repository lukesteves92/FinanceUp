package com.inspirecoding.financeup.ui.components.spending.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.inspirecoding.financeup.extensions.formatCurrency
import com.inspirecoding.financeup.model.spending.SpendingItem
import com.inspirecoding.financeup.ui.color.FinanceUpColorBaselineWhite
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.ui.typography.FinanceUpTypography
import com.inspirecoding.financeup.ui.typography.LTAsusFontFamily
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusLg
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimen3XLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenExtraLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenExtraWideM
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpOpacity70Percent
import com.inspirecoding.financeup.util.variables.Variables.financeUpOpacity90Percent

@Composable
fun SpendingCard(
    spendingItem: SpendingItem,
    modifier: Modifier = Modifier,
    onDeleteItem: (SpendingItem) -> Unit
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

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = spendingItem.type.icon,
                    contentDescription = spendingItem.name,
                    modifier = Modifier.size(financeUpDimen3XLarge),
                    tint = FinanceUpColorBaselineWhite
                )

                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = Icons.Rounded.Close.name,
                    modifier = Modifier
                        .clickable { onDeleteItem(spendingItem) }
                        .size(financeUpDimenExtraLarge)
                    ,
                    tint = FinanceUpColorBaselineWhite
                )
            }

            Text(
                fontFamily = LTAsusFontFamily(),
                text = spendingItem.name,
                style = FinanceUpTypography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = spendingItem.amount.formatCurrency(),
                style = FinanceUpTypography.titleMedium,
                fontFamily = LTAsusFontFamily(),
            )

            Text(
                text = spendingItem.purchaseDate,
                style = FinanceUpTypography.titleMedium,
                fontFamily = LTAsusFontFamily(),
                color = FinanceUpColorBaselineWhite.copy(alpha = financeUpOpacity70Percent)
            )
        }
    }
}