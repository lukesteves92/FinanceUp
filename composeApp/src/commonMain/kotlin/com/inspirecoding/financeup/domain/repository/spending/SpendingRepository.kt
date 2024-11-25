package com.inspirecoding.financeup.domain.repository.spending

import com.inspirecoding.financeup.model.spending.SpendingItem
import kotlinx.coroutines.flow.Flow

interface SpendingRepository {
    suspend fun insertSpending(spendingItem: SpendingItem)
    suspend fun insertSpendings(spendingItems: List<SpendingItem>)
    fun getSpendingByDate(date: String): Flow<List<SpendingItem>>
    fun getAllSpendings(): Flow<List<SpendingItem>>
    suspend fun deleteSpending(spendingItem: SpendingItem)
    suspend fun deleteSpendingsByDate(date: String)
    suspend fun deleteAllSpendings()
}