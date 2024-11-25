package com.inspirecoding.financeup.features.home.action

import com.inspirecoding.financeup.model.income.IncomeItem
import com.inspirecoding.financeup.model.spending.SpendingItem

sealed interface HomeAction {
    data class AddIncome(val incomeItem: IncomeItem) : HomeAction
    data class DeleteIncome(val incomeItem: IncomeItem) : HomeAction

    data class AddSpending(val spendingItem: SpendingItem) : HomeAction
    data class DeleteSpending(val spendingItem: SpendingItem) : HomeAction

    data class UpdateSelectedDate(val date: String) : HomeAction

    data object LoadInitialData : HomeAction
}