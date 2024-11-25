package com.inspirecoding.financeup.data.spending

import com.inspirecoding.financeup.data.mapping.toEntity
import com.inspirecoding.financeup.data.mapping.toModel
import com.inspirecoding.financeup.database.db.FinanceUpDatabase
import com.inspirecoding.financeup.domain.repository.spending.SpendingRepository
import com.inspirecoding.financeup.model.spending.SpendingItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SpendingRepositoryImpl(private val database: FinanceUpDatabase) : SpendingRepository {

    override suspend fun insertSpending(spendingItem: SpendingItem) {
        val entity = spendingItem.toEntity()
        database.spendingDao().insertSpending(entity)
    }

    override suspend fun insertSpendings(spendingItems: List<SpendingItem>) {
        val entities = spendingItems.map { it.toEntity() }
        database.spendingDao().insertSpendings(entities)
    }

    override fun getSpendingByDate(date: String): Flow<List<SpendingItem>> = flow {
        database.spendingDao().getSpendingByDate(date).collect { entities ->
            emit(entities.map { it.toModel() })
        }
    }

    override fun getAllSpendings(): Flow<List<SpendingItem>> = flow {
        database.spendingDao().getAllSpendings().collect { entities ->
            emit(entities.map { it.toModel() })
        }
    }

    override suspend fun deleteSpending(spendingItem: SpendingItem) {
        val entity = spendingItem.toEntity()
        database.spendingDao().deleteSpending(entity)
    }

    override suspend fun deleteSpendingsByDate(date: String) {
        database.spendingDao().deleteSpendingsByDate(date)
    }

    override suspend fun deleteAllSpendings() {
        database.spendingDao().deleteAllSpendings()
    }
}