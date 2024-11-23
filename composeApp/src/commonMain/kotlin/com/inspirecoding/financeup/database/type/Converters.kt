package com.inspirecoding.financeup.database.type

import androidx.room.TypeConverter
import com.inspirecoding.financeup.util.enums.expensetype.ExpenseType
import com.inspirecoding.financeup.util.enums.incometype.IncomeType

class Converters {
    @TypeConverter
    fun fromIncomeType(type: IncomeType): String = type.name

    @TypeConverter
    fun toIncomeType(name: String): IncomeType = IncomeType.valueOf(name)

    @TypeConverter
    fun fromExpenseType(type: ExpenseType): String = type.name

    @TypeConverter
    fun toExpenseType(name: String): ExpenseType = ExpenseType.valueOf(name)
}