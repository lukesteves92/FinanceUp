package com.inspirecoding.financeup.data.spending

import com.inspirecoding.financeup.data.mapping.toEntity
import com.inspirecoding.financeup.data.mapping.toModel
import com.inspirecoding.financeup.database.dao.spending.SpendingDao
import com.inspirecoding.financeup.database.db.FinanceUpDatabase
import com.inspirecoding.financeup.domain.repository.spending.SpendingRepository
import com.inspirecoding.financeup.model.spending.SpendingItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class SpendingRepositoryImpl(private val database: FinanceUpDatabase) : SpendingRepository {

    private val spendingDao = database.spendingDao()

    override suspend fun insertSpending(spendingItem: SpendingItem) {
        val entity = spendingItem.toEntity()
        spendingDao.insertSpending(entity)
    }

    override suspend fun insertSpendings(spendingItems: List<SpendingItem>) {
        val entities = spendingItems.map { it.toEntity() }
        spendingDao.insertSpendings(entities)
    }

    override fun getSpendingByDate(date: String): Flow<List<SpendingItem>> = flow {
        spendingDao.getSpendingByDate(date).collect { entities ->
            emit(entities.map { it.toModel() })
        }
    }

    override fun getAllSpendings(): Flow<List<SpendingItem>> = flow {
        spendingDao.getAllSpendings().collect { entities ->
            emit(entities.map { it.toModel() })
        }
    }

    override suspend fun deleteSpending(spendingItem: SpendingItem) {
        val entity = spendingItem.toEntity()
        spendingDao.deleteSpending(entity)
    }

    override suspend fun deleteSpendingsByDate(date: String) {
        spendingDao.deleteSpendingsByDate(date)
    }

    override suspend fun deleteAllSpendings() {
        spendingDao.deleteAllSpendings()
    }
}