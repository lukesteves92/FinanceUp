package com.inspirecoding.financeup.data.mapping

import com.inspirecoding.financeup.database.entity.income.IncomeEntity
import com.inspirecoding.financeup.database.entity.spending.SpendingEntity
import com.inspirecoding.financeup.model.income.IncomeItem
import com.inspirecoding.financeup.model.spending.SpendingItem
import com.inspirecoding.financeup.util.enums.expensetype.ExpenseType
import com.inspirecoding.financeup.util.enums.incometype.IncomeType

fun SpendingItem.toEntity(): SpendingEntity {
    return SpendingEntity(
        id = this.id,
        name = this.name,
        amount = this.amount,
        type = this.type.id,
        purchaseDate = this.purchaseDate
    )
}

fun SpendingEntity.toModel(): SpendingItem {
    return SpendingItem(
        id = this.id,
        name = this.name,
        amount = this.amount,
        type = ExpenseType.fromId(this.type),
        purchaseDate = this.purchaseDate
    )
}

fun IncomeItem.toEntity(): IncomeEntity {
    return IncomeEntity(
        id = this.id,
        name = this.name,
        amount = this.amount,
        type = this.type.id,
        receivedDate = this.receivedDate
    )
}

fun IncomeEntity.toModel(): IncomeItem {
    return IncomeItem(
        id = this.id,
        name = this.name,
        amount = this.amount,
        type = IncomeType.fromId(this.type),
        receivedDate = this.receivedDate
    )
}