package com.inspirecoding.financeup.domain.usecase.spending

import com.inspirecoding.financeup.domain.repository.spending.SpendingRepository
import com.inspirecoding.financeup.model.SpendingItem
import kotlinx.coroutines.flow.Flow

class GetSpendingUseCase(
    private val spendingRepository: SpendingRepository
) {
    fun getSpendingByDate(date: String): Flow<List<SpendingItem>> {
        return spendingRepository.getSpendingByDate(date)
    }

    fun getAllSpendings(): Flow<List<SpendingItem>> {
        return spendingRepository.getAllSpendings()
    }

    suspend fun insertSpending(spendingItem: SpendingItem) {
        spendingRepository.insertSpending(spendingItem)
    }

    suspend fun insertSpendings(spendingItems: List<SpendingItem>) {
        spendingRepository.insertSpendings(spendingItems)
    }

    suspend fun deleteSpending(spendingItem: SpendingItem) {
        spendingRepository.deleteSpending(spendingItem)
    }

    suspend fun deleteSpendingsByDate(date: String) {
        spendingRepository.deleteSpendingsByDate(date)
    }

    suspend fun deleteAllSpendings() {
        spendingRepository.deleteAllSpendings()
    }
}