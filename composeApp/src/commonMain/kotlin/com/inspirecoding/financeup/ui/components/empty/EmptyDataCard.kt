package com.inspirecoding.financeup.ui.components.empty

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.inspirecoding.financeup.ui.color.FinanceUpColorBaselineWhite
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.ui.typography.FinanceUpTypography
import com.inspirecoding.financeup.ui.typography.LTAsusFontFamily
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusLg
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimen3XLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenExtraWideM
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenMedium
import com.inspirecoding.financeup.util.variables.Variables.financeUpOpacity90Percent
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.text_no_data
import org.jetbrains.compose.resources.stringResource

@Composable
fun EmptyDataCard(
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
            horizontalAlignment = Alignment.Start
        ) {
            Icon(
                imageVector = Icons.Rounded.Warning,
                contentDescription = stringResource(Res.string.text_no_data),
                modifier = Modifier.size(financeUpDimen3XLarge),
                tint = FinanceUpColorBaselineWhite
            )
            Spacer(modifier = Modifier.height(financeUpDimenMedium))
            Text(
                text = stringResource(Res.string.text_no_data),
                style = FinanceUpTypography.titleMedium,
                fontFamily = LTAsusFontFamily(),
                fontWeight = FontWeight.Bold,
                color = FinanceUpColorBaselineWhite
            )
        }
    }
}