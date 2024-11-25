package com.inspirecoding.financeup.model.spending

import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_NUMBER_ZERO_LONG
import com.inspirecoding.financeup.util.enums.expensetype.ExpenseType

data class SpendingItem(
    val id: Long = KEY_NUMBER_ZERO_LONG,
    val name: String,
    val amount: Float,
    val type: ExpenseType,
    val purchaseDate: String
)
