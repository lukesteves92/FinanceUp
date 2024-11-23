package com.inspirecoding.financeup.ui.components.bottomsheet.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.inspirecoding.financeup.extensions.displayName
import com.inspirecoding.financeup.extensions.formatCurrency
import com.inspirecoding.financeup.extensions.toRawAmount
import com.inspirecoding.financeup.model.IncomeItem
import com.inspirecoding.financeup.model.SpendingItem
import com.inspirecoding.financeup.ui.components.button.OutlineButtonUI
import com.inspirecoding.financeup.ui.components.chip.CustomChip
import com.inspirecoding.financeup.ui.components.input.InputTextField
import com.inspirecoding.financeup.ui.typography.FinanceUpTypography
import com.inspirecoding.financeup.ui.typography.LTAsusFontFamily
import com.inspirecoding.financeup.util.constants.Constants.ProgressConstants.MAX_PROGRESS
import com.inspirecoding.financeup.util.constants.Constants.ProgressConstants.MIN_PROGRESS
import com.inspirecoding.financeup.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import com.inspirecoding.financeup.util.enums.expensetype.ExpenseType
import com.inspirecoding.financeup.util.enums.incometype.IncomeType
import com.inspirecoding.financeup.util.enums.inputtext.TextFieldState
import com.inspirecoding.financeup.util.enums.sheet.DefaultSheetType
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenMedium
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenSmall
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.default_sheet_add_button
import financeup.composeapp.generated.resources.default_sheet_add_expense_title
import financeup.composeapp.generated.resources.default_sheet_add_income_title
import financeup.composeapp.generated.resources.default_sheet_close_button
import financeup.composeapp.generated.resources.default_sheet_date_hint
import financeup.composeapp.generated.resources.default_sheet_date_label
import financeup.composeapp.generated.resources.default_sheet_error_message
import financeup.composeapp.generated.resources.default_sheet_name_hint
import financeup.composeapp.generated.resources.default_sheet_name_label
import financeup.composeapp.generated.resources.default_sheet_value_hint
import financeup.composeapp.generated.resources.default_sheet_value_label
import org.jetbrains.compose.resources.stringResource

@Composable
fun DefaultSheetScreen(
    type: DefaultSheetType = DefaultSheetType.INCOME,
    onAddIncomeClick: (IncomeItem) -> Unit,
    onAddExpenseClick: (SpendingItem) -> Unit,
    onCloseClick: () -> Unit
) {
    var selectedType by remember { mutableStateOf(if (type == DefaultSheetType.INCOME) IncomeType.SALARY else ExpenseType.FOOD) }
    var name by remember { mutableStateOf(EMPTY_STRING_DEFAULT) }
    var amount by remember { mutableStateOf(EMPTY_STRING_DEFAULT) }
    var rawAmount by remember { mutableStateOf(MIN_PROGRESS) }
    var date by remember { mutableStateOf(EMPTY_STRING_DEFAULT) }
    var isNameError by remember { mutableStateOf(false) }
    var isAmountError by remember { mutableStateOf(false) }
    var isDateError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(financeUpDimenLarge)
            .verticalScroll(rememberScrollState())
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            fontFamily = LTAsusFontFamily(),
            text = if (type == DefaultSheetType.INCOME) {
                stringResource(Res.string.default_sheet_add_income_title)
            } else {
                stringResource(Res.string.default_sheet_add_expense_title)
            },
            style = FinanceUpTypography.headlineLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(financeUpDimenLarge))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(financeUpDimenSmall)
        ) {
            if (type == DefaultSheetType.INCOME) {
                items(IncomeType.entries) { incomeType ->
                    CustomChip(
                        text = incomeType.displayName(),
                        selected = selectedType == incomeType,
                        onClick = { selectedType = incomeType }
                    )
                }
            } else {
                items(ExpenseType.entries) { expenseType ->
                    CustomChip(
                        text = expenseType.displayName(),
                        selected = selectedType == expenseType,
                        onClick = { selectedType = expenseType }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(financeUpDimenLarge))

        InputTextField(
            text = name,
            hintText = stringResource(Res.string.default_sheet_name_hint),
            label = stringResource(Res.string.default_sheet_name_label),
            errorMessage = if (isNameError) stringResource(Res.string.default_sheet_error_message) else EMPTY_STRING_DEFAULT,
            state = if (isNameError) TextFieldState.ERROR else TextFieldState.DEFAULT,
            onTextChange = {
                name = it
                isNameError = false
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(financeUpDimenMedium))

        InputTextField(
            text = amount,
            hintText = stringResource(Res.string.default_sheet_value_hint),
            label = stringResource(Res.string.default_sheet_value_label),
            errorMessage = if (isAmountError) stringResource(Res.string.default_sheet_error_message) else EMPTY_STRING_DEFAULT,
            state = if (isAmountError) TextFieldState.ERROR else TextFieldState.DEFAULT,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onTextChange = { input ->
                rawAmount = input.toRawAmount()
                amount = rawAmount.formatCurrency()
                isAmountError = false
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(financeUpDimenMedium))

        InputTextField(
            text = date,
            hintText = stringResource(Res.string.default_sheet_date_hint),
            label = stringResource(Res.string.default_sheet_date_label),
            errorMessage = if (isDateError) stringResource(Res.string.default_sheet_error_message) else EMPTY_STRING_DEFAULT,
            state = if (isDateError) TextFieldState.ERROR else TextFieldState.DEFAULT,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            onTextChange = {
                date = it
                isDateError = false
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(financeUpDimenLarge))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlineButtonUI(
                modifier = Modifier
                    .weight(MAX_PROGRESS)
                    .padding(end = financeUpDimenSmall),
                text = stringResource(Res.string.default_sheet_close_button),
                onClick = onCloseClick
            )

            OutlineButtonUI(
                modifier = Modifier.weight(1f),
                text = stringResource(Res.string.default_sheet_add_button),
                onClick = {
                    isNameError = name.isEmpty()
                    isAmountError = rawAmount <= MIN_PROGRESS
                    isDateError = date.isEmpty()

                    if (!isNameError && !isAmountError && !isDateError) {
                        if (type == DefaultSheetType.INCOME) {
                            onAddIncomeClick(
                                IncomeItem(
                                    name = name,
                                    amount = rawAmount,
                                    type = selectedType as IncomeType,
                                    receivedDate = date
                                )
                            )
                        } else {
                            onAddExpenseClick(
                                SpendingItem(
                                    name = name,
                                    amount = rawAmount,
                                    type = selectedType as ExpenseType,
                                    purchaseDate = date
                                )
                            )
                        }
                    }
                }
            )
        }
    }
}