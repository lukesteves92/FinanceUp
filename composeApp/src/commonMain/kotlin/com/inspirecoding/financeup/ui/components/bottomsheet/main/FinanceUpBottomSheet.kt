package com.inspirecoding.financeup.ui.components.bottomsheet.main

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.inspirecoding.financeup.model.IncomeItem
import com.inspirecoding.financeup.model.SpendingItem
import com.inspirecoding.financeup.ui.components.bottomsheet.default.DefaultSheetLayout
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.util.enums.sheet.DefaultSheetType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinanceUpBottomSheet(
    isSheetOpen: Boolean,
    containerColor: Color = FinanceUpTheme.colorScheme.screen.background,
    type: DefaultSheetType = DefaultSheetType.INCOME,
    onDismissRequest: (Boolean) -> Unit,
    onAddIncomeClick: (IncomeItem, Boolean) -> Unit,
    onAddExpenseClick: (SpendingItem, Boolean) -> Unit
) {

    val sheetState =
        rememberModalBottomSheetState(
            skipPartiallyExpanded = true,
            confirmValueChange = { newState ->
                newState != SheetValue.Hidden
            })

    if (isSheetOpen) {
        ModalBottomSheet(
            containerColor = containerColor,
            sheetState = sheetState,
            onDismissRequest = { onDismissRequest.invoke(false) },
            content = {

                DefaultSheetLayout(
                    type = type,
                    onAddIncomeClick = { income -> onAddIncomeClick(income, false) },
                    onAddExpenseClick = { expense -> onAddExpenseClick(expense, false) },
                    onCloseClick = { onDismissRequest.invoke(false) }
                )
            }
        )
    }
}