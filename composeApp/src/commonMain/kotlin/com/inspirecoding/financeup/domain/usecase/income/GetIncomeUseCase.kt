package com.inspirecoding.financeup.domain.usecase.income

import com.inspirecoding.financeup.domain.repository.income.IncomeRepository
import com.inspirecoding.financeup.model.IncomeItem
import kotlinx.coroutines.flow.Flow

class GetIncomeUseCase(
    private val incomeRepository: IncomeRepository
) {
    fun getIncomeByDate(date: String): Flow<List<IncomeItem>> {
        return incomeRepository.getIncomeByDate(date)
    }

    fun getAllIncomes(): Flow<List<IncomeItem>> {
        return incomeRepository.getAllIncomes()
    }

    suspend fun insertIncome(incomeItem: IncomeItem) {
        incomeRepository.insertIncome(incomeItem)
    }

    suspend fun insertIncomes(incomeItems: List<IncomeItem>) {
        incomeRepository.insertIncomes(incomeItems)
    }

    suspend fun deleteIncome(incomeItem: IncomeItem) {
        incomeRepository.deleteIncome(incomeItem)
    }

    suspend fun deleteIncomesByDate(date: String) {
        incomeRepository.deleteIncomesByDate(date)
    }

    suspend fun deleteAllIncomes() {
        incomeRepository.deleteAllIncomes()
    }
}