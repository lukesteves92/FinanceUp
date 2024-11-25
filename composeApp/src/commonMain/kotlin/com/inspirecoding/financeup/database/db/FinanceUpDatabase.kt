package com.inspirecoding.financeup.database.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.inspirecoding.financeup.database.dao.income.IncomeDao
import com.inspirecoding.financeup.database.dao.spending.SpendingDao
import com.inspirecoding.financeup.database.entity.income.IncomeEntity
import com.inspirecoding.financeup.database.entity.spending.SpendingEntity

@Database(
    entities = [IncomeEntity::class, SpendingEntity::class],
    version = 1,
    exportSchema = true
)

@ConstructedBy(FinanceUpDatabaseConstructor::class)
abstract class FinanceUpDatabase : RoomDatabase() {
    abstract fun incomeDao(): IncomeDao
    abstract fun spendingDao(): SpendingDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object FinanceUpDatabaseConstructor : RoomDatabaseConstructor<FinanceUpDatabase> {
    override fun initialize(): FinanceUpDatabase
}