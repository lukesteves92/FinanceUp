package com.inspirecoding.financeup.ui.components.expenses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.inspirecoding.financeup.ui.components.total.TotalCard
import com.inspirecoding.financeup.ui.typography.FinanceUpTypography
import com.inspirecoding.financeup.util.constants.Constants.ProgressConstants.MAX_PROGRESS
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenLarge
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.text_expenses_and_incomes_component_title
import financeup.composeapp.generated.resources.text_expenses_component_title
import financeup.composeapp.generated.resources.text_incomes_component_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun ExpensesAndIncomes(
    totalExpenses: () -> Float,
    totalIncomes: () -> Float
) {
    Column(modifier = Modifier.padding(financeUpDimenLarge)) {
        Text(
            text = stringResource(Res.string.text_expenses_and_incomes_component_title),
            style = FinanceUpTypography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = financeUpDimenLarge)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TotalCard(
                title = stringResource(Res.string.text_expenses_component_title),
                amountProvider = totalExpenses,
                cardColor = Color.Red,
                modifier = Modifier.weight(MAX_PROGRESS)
            )

            Spacer(modifier = Modifier.width(financeUpDimenLarge))

            TotalCard(
                title = stringResource(Res.string.text_incomes_component_title),
                amountProvider = totalIncomes,
                cardColor = Color.Green,
                modifier = Modifier.weight(MAX_PROGRESS)
            )
        }
    }
}