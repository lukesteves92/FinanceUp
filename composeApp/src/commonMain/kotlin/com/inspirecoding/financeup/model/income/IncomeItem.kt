package com.inspirecoding.financeup.model.income

import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_NUMBER_ZERO_LONG
import com.inspirecoding.financeup.util.enums.incometype.IncomeType

data class IncomeItem(
    val id: Long = KEY_NUMBER_ZERO_LONG,
    val name: String,
    val amount: Float,
    val type: IncomeType,
    val receivedDate: String
)
