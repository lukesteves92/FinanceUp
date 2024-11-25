package com.inspirecoding.financeup.features.home.state

import com.inspirecoding.financeup.model.income.IncomeItem
import com.inspirecoding.financeup.model.spending.SpendingItem
import com.inspirecoding.financeup.util.constants.Constants.Text.EMPTY_STRING_DEFAULT

data class HomeState(
    val incomeItems: List<IncomeItem> = emptyList(),
    val spendingItems: List<SpendingItem> = emptyList(),
    val currentSelectedDate: String = EMPTY_STRING_DEFAULT,
) {
    val availableDates: List<String>
        get() = (spendingItems.map { it.purchaseDate } + incomeItems.map { it.receivedDate })
            .distinct()
            .sortedDescending()

    val filteredIncomeItems: List<IncomeItem>
        get() = incomeItems.filter { it.receivedDate == currentSelectedDate }

    val filteredSpendingItems: List<SpendingItem>
        get() = spendingItems.filter { it.purchaseDate == currentSelectedDate }

    val totalExpenses: Float
        get() = filteredSpendingItems.sumOf { it.amount.toDouble() }.toFloat()

    val totalIncomes: Float
        get() = filteredIncomeItems.sumOf { it.amount.toDouble() }.toFloat()
}