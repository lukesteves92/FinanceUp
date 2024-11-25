package com.inspirecoding.financeup.domain.repository.income

import com.inspirecoding.financeup.model.income.IncomeItem
import kotlinx.coroutines.flow.Flow

interface IncomeRepository {
    suspend fun insertIncome(incomeItem: IncomeItem)
    suspend fun insertIncomes(incomeItems: List<IncomeItem>)
    fun getIncomeByDate(date: String): Flow<List<IncomeItem>>
    fun getAllIncomes(): Flow<List<IncomeItem>>
    suspend fun deleteIncome(incomeItem: IncomeItem)
    suspend fun deleteIncomesByDate(date: String)
    suspend fun deleteAllIncomes()
}