package com.inspirecoding.financeup.model

import com.inspirecoding.financeup.util.enums.expensetype.ExpenseType

data class SpendingItem(
    val name: String,
    val amount: Float,
    val type: ExpenseType,
    val purchaseDate: String
)
