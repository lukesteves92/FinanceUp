package com.inspirecoding.financeup.ui.components.bottomsheet.default

import androidx.compose.runtime.Composable
import com.inspirecoding.financeup.model.income.IncomeItem
import com.inspirecoding.financeup.model.spending.SpendingItem
import com.inspirecoding.financeup.ui.components.bottomsheet.screen.DefaultSheetScreen
import com.inspirecoding.financeup.util.enums.sheet.DefaultSheetType

@Composable
fun DefaultSheetLayout(
    type: DefaultSheetType = DefaultSheetType.INCOME,
    onAddIncomeClick: (IncomeItem) -> Unit,
    onAddExpenseClick: (SpendingItem) -> Unit,
    onCloseClick: () -> Unit
) {
    BottomSheetBody {
        DefaultSheetScreen(
            type = type,
            onAddIncomeClick = onAddIncomeClick,
            onAddExpenseClick = onAddExpenseClick,
            onCloseClick = onCloseClick
        )
    }
}

@Composable
fun BottomSheetBody(content: @Composable () -> Unit) = content()