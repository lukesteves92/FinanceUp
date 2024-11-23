package com.inspirecoding.financeup.ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.ui.typography.FinanceUpTypography
import com.inspirecoding.financeup.ui.typography.LTAsusFontFamily
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusS
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusSm
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimen4XsSLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpOpacity90Percent

@Composable
fun OutlineButtonUI(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    val defaultBorder = BorderStroke(
        width = financeUpBorderRadiusS,
        color = FinanceUpTheme.colorScheme.outlineButton.border
    )

    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .height(financeUpDimen4XsSLarge),
        shape = RoundedCornerShape(financeUpBorderRadiusSm),
        colors = ButtonDefaults.buttonColors(
            containerColor = FinanceUpTheme.colorScheme.screen.background.copy(alpha = financeUpOpacity90Percent)
        ),
        border = defaultBorder,
        content = {
            Text(
                fontFamily = LTAsusFontFamily(),
                text = text,
                style = FinanceUpTypography.titleSmall,
                fontWeight = FontWeight.Bold
            )
        },
    )
}