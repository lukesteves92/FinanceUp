package com.inspirecoding.financeup.ui.components.expenses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.inspirecoding.financeup.ui.color.FinanceUpColorBaselineWhite
import com.inspirecoding.financeup.ui.components.total.TotalCard
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.ui.typography.FinanceUpTypography
import com.inspirecoding.financeup.ui.typography.LTAsusFontFamily
import com.inspirecoding.financeup.util.constants.Constants.ProgressConstants.MAX_PROGRESS
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenExtraWideLs
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenLarge
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.text_expenses_and_incomes_component_title
import financeup.composeapp.generated.resources.text_expenses_component_title
import financeup.composeapp.generated.resources.text_incomes_component_title
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpensesAndIncomes(
    totalExpenses: () -> Float,
    totalIncomes: () -> Float,
    selectedDate: () -> String,
    onDateChange: (String) -> Unit,
    availableDates: () -> List<String>
) {
    var expanded by remember { mutableStateOf(false) }
    val dates = availableDates()
    val hasDates = dates.isNotEmpty()

    LaunchedEffect(dates) {
        when {
            dates.isEmpty() -> onDateChange("")
            !dates.contains(selectedDate()) -> onDateChange(dates.first())
        }
    }

    Column(modifier = Modifier.padding(financeUpDimenLarge)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = financeUpDimenLarge),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                fontFamily = LTAsusFontFamily(),
                text = stringResource(Res.string.text_expenses_and_incomes_component_title),
                style = FinanceUpTypography.titleLarge,
                fontWeight = FontWeight.Bold,
            )

            if (hasDates) {
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    TextField(
                        value = selectedDate(),
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .width(financeUpDimenExtraWideLs)
                            .menuAnchor(
                                type = MenuAnchorType.PrimaryNotEditable,
                                enabled = true
                            ),
                        trailingIcon = {
                            Icon(
                                Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                tint = FinanceUpColorBaselineWhite
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = FinanceUpTheme.colorScheme.textField.text,
                            unfocusedTextColor = FinanceUpTheme.colorScheme.textField.text,
                            disabledTextColor = FinanceUpTheme.colorScheme.textField.disable,
                            focusedIndicatorColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            errorContainerColor = Color.Transparent,
                            cursorColor = FinanceUpTheme.colorScheme.textField.cursor
                        )
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        dates.forEach { date ->
                            DropdownMenuItem(
                                text = { Text(text = date) },
                                onClick = {
                                    onDateChange(date)
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TotalCard(
                title = stringResource(Res.string.text_expenses_component_title),
                amountProvider = { if (hasDates) totalExpenses() else 0f },
                cardColor = Color.Red,
                modifier = Modifier.weight(MAX_PROGRESS)
            )

            Spacer(modifier = Modifier.width(financeUpDimenLarge))

            TotalCard(
                title = stringResource(Res.string.text_incomes_component_title),
                amountProvider = { if (hasDates) totalIncomes() else 0f },
                cardColor = Color.Green,
                modifier = Modifier.weight(MAX_PROGRESS)
            )
        }
    }
}
