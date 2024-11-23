package com.inspirecoding.financeup.data.spending

import com.inspirecoding.financeup.database.db.FinanceUpDatabase
import com.inspirecoding.financeup.database.entity.spending.SpendingEntity
import com.inspirecoding.financeup.domain.repository.spending.SpendingRepository
import com.inspirecoding.financeup.model.SpendingItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SpendingRepositoryImpl(private val database: FinanceUpDatabase) : SpendingRepository {

    private val spendingDao = database.spendingDao()

    override suspend fun insertSpending(spendingItem: SpendingItem) {
        val entity = SpendingEntity(
            name = spendingItem.name,
            amount = spendingItem.amount,
            type = spendingItem.type,
            purchaseDate = spendingItem.purchaseDate
        )
        spendingDao.insertSpending(entity)
    }

    override suspend fun insertSpendings(spendingItems: List<SpendingItem>) {
        val entities = spendingItems.map {
            SpendingEntity(
                name = it.name,
                amount = it.amount,
                type = it.type,
                purchaseDate = it.purchaseDate
            )
        }
        spendingDao.insertSpendings(entities)
    }

    override fun getSpendingByDate(date: String): Flow<List<SpendingItem>> {
        return spendingDao.getSpendingByDate(date).map { entities ->
            entities.map { entity ->
                SpendingItem(
                    name = entity.name,
                    amount = entity.amount,
                    type = entity.type,
                    purchaseDate = entity.purchaseDate
                )
            }
        }
    }

    override fun getAllSpendings(): Flow<List<SpendingItem>> {
        return spendingDao.getAllSpendings().map { entities ->
            entities.map { entity ->
                SpendingItem(
                    name = entity.name,
                    amount = entity.amount,
                    type = entity.type,
                    purchaseDate = entity.purchaseDate
                )
            }
        }
    }

    override suspend fun deleteSpending(spendingItem: SpendingItem) {
        val entity = SpendingEntity(
            name = spendingItem.name,
            amount = spendingItem.amount,
            type = spendingItem.type,
            purchaseDate = spendingItem.purchaseDate
        )
        spendingDao.deleteSpending(entity)
    }

    override suspend fun deleteSpendingsByDate(date: String) {
        spendingDao.deleteSpendingsByDate(date)
    }

    override suspend fun deleteAllSpendings() {
        spendingDao.deleteAllSpendings()
    }
}