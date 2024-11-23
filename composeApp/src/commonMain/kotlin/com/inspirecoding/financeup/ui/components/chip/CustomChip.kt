package com.inspirecoding.financeup.ui.components.chip

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.inspirecoding.financeup.ui.color.CustomChipBackgroundColorDisabled
import com.inspirecoding.financeup.ui.color.CustomChipBackgroundColorSelected
import com.inspirecoding.financeup.ui.color.CustomChipTextColor
import com.inspirecoding.financeup.ui.typography.FinanceUpTypography
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusLg
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusMd
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusSm
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenExtraSmall
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenMicro
import com.inspirecoding.financeup.util.variables.Variables.financeUpOpacity90Percent

@Composable
fun CustomChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(horizontal = financeUpDimenExtraSmall, vertical = financeUpDimenMicro)
            .wrapContentWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) {
                CustomChipBackgroundColorSelected.copy(alpha = financeUpOpacity90Percent)
            } else {
                CustomChipBackgroundColorDisabled
            }
        ),
        shape = RoundedCornerShape(financeUpBorderRadiusLg)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(horizontal = financeUpBorderRadiusMd, vertical = financeUpBorderRadiusSm),
            style = FinanceUpTypography.bodySmall,
            color = CustomChipTextColor
        )
    }
}