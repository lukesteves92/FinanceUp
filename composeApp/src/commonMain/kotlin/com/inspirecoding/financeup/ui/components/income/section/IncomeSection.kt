package com.inspirecoding.financeup.ui.components.income.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.inspirecoding.financeup.model.IncomeItem
import com.inspirecoding.financeup.ui.components.income.card.IncomeCard
import com.inspirecoding.financeup.ui.typography.FinanceUpTypography
import com.inspirecoding.financeup.ui.typography.LTAsusFontFamily
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenSmallMedium
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.text_income_section_component_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun IncomeSection(
    modifier: Modifier = Modifier,
    incomeItemsProvider: () -> List<IncomeItem>
) {

    val incomeItems = incomeItemsProvider()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = financeUpDimenLarge, vertical = financeUpDimenLarge)
    ) {
        Text(
            text = stringResource(Res.string.text_income_section_component_title),
            fontFamily = LTAsusFontFamily(),
            style = FinanceUpTypography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = financeUpDimenSmallMedium)
        )

        Spacer(modifier = Modifier.height(financeUpDimenLarge))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = financeUpDimenSmallMedium),
            horizontalArrangement = Arrangement.spacedBy(financeUpDimenLarge)
        ) {
            items(incomeItems) { item ->
                IncomeCard(incomeItem = item)
            }
        }
    }
}