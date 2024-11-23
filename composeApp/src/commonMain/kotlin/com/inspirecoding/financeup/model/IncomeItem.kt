package com.inspirecoding.financeup.model

import com.inspirecoding.financeup.util.enums.incometype.IncomeType

data class IncomeItem(
    val name: String,
    val amount: Float,
    val type: IncomeType,
    val receivedDate: String
)
