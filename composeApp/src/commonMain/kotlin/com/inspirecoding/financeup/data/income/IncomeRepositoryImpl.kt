package com.inspirecoding.financeup.data.income

import com.inspirecoding.financeup.data.mapping.toEntity
import com.inspirecoding.financeup.data.mapping.toModel
import com.inspirecoding.financeup.database.db.FinanceUpDatabase
import com.inspirecoding.financeup.domain.repository.income.IncomeRepository
import com.inspirecoding.financeup.model.income.IncomeItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class IncomeRepositoryImpl(private val database: FinanceUpDatabase) : IncomeRepository {

    override suspend fun insertIncome(incomeItem: IncomeItem) {
        val entity = incomeItem.toEntity()
        database.incomeDao().insertIncome(entity)
    }

    override suspend fun insertIncomes(incomeItems: List<IncomeItem>) {
        val entities = incomeItems.map { it.toEntity() }
        database.incomeDao().insertIncomes(entities)
    }

    override fun getIncomeByDate(date: String): Flow<List<IncomeItem>> = flow {
        database.incomeDao().getIncomeByDate(date).collect { entities ->
            emit(entities.map { it.toModel() })
        }
    }

    override fun getAllIncomes(): Flow<List<IncomeItem>> = flow {
        database.incomeDao().getAllIncomes().collect { entities ->
            emit(entities.map { it.toModel() })
        }
    }

    override suspend fun deleteIncome(incomeItem: IncomeItem) {
        val entity = incomeItem.toEntity()
        database.incomeDao().deleteIncome(entity)
    }

    override suspend fun deleteIncomesByDate(date: String) {
        database.incomeDao().deleteIncomesByDate(date)
    }

    override suspend fun deleteAllIncomes() {
        database.incomeDao().deleteAllIncomes()
    }
}