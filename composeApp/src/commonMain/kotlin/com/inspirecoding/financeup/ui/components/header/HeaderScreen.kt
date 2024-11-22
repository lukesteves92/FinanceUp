package com.inspirecoding.financeup.ui.components.header

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.ui.typography.LTAsusFontFamily
import com.inspirecoding.financeup.util.variables.Variables
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenMedium
import com.inspirecoding.financeup.util.variables.Variables.financeUpLineHeightHeaderSubtitle
import com.inspirecoding.financeup.util.variables.Variables.financeUpLineHeightHeaderTitle

@Composable
fun HeaderScreen(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = Variables.financeUpSizeXs,
                lineHeight = financeUpLineHeightHeaderTitle,
                fontFamily = LTAsusFontFamily(),
                fontWeight = FontWeight(Variables.financeUpFontWeightBold),
                color = FinanceUpTheme.colorScheme.text.color
            )
        )

        Spacer(modifier = Modifier.height(financeUpDimenMedium))

        Text(
            text = subTitle,
            style = TextStyle(
                lineHeight = financeUpLineHeightHeaderSubtitle,
                fontFamily = LTAsusFontFamily(),
                fontWeight = FontWeight(Variables.financeUpFontWeightLight),
                color = FinanceUpTheme.colorScheme.text.color
            )
        )
    }
}