package com.inspirecoding.financeup.data.income

import com.inspirecoding.financeup.database.db.FinanceUpDatabase
import com.inspirecoding.financeup.database.entity.income.IncomeEntity
import com.inspirecoding.financeup.domain.repository.income.IncomeRepository
import com.inspirecoding.financeup.model.IncomeItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class IncomeRepositoryImpl(private val database: FinanceUpDatabase) : IncomeRepository {

    private val incomeDao = database.incomeDao()

    override suspend fun insertIncome(incomeItem: IncomeItem) {
        val entity = IncomeEntity(
            name = incomeItem.name,
            amount = incomeItem.amount,
            type = incomeItem.type,
            receivedDate = incomeItem.receivedDate
        )
        incomeDao.insertIncome(entity)
    }

    override suspend fun insertIncomes(incomeItems: List<IncomeItem>) {
        val entities = incomeItems.map {
            IncomeEntity(
                name = it.name,
                amount = it.amount,
                type = it.type,
                receivedDate = it.receivedDate
            )
        }
        incomeDao.insertIncomes(entities)
    }

    override fun getIncomeByDate(date: String): Flow<List<IncomeItem>> {
        return incomeDao.getIncomeByDate(date).map { entities ->
            entities.map { entity ->
                IncomeItem(
                    name = entity.name,
                    amount = entity.amount,
                    type = entity.type,
                    receivedDate = entity.receivedDate
                )
            }
        }
    }

    override fun getAllIncomes(): Flow<List<IncomeItem>> {
        return incomeDao.getAllIncomes().map { entities ->
            entities.map { entity ->
                IncomeItem(
                    name = entity.name,
                    amount = entity.amount,
                    type = entity.type,
                    receivedDate = entity.receivedDate
                )
            }
        }
    }

    override suspend fun deleteIncome(incomeItem: IncomeItem) {
        val entity = IncomeEntity(
            name = incomeItem.name,
            amount = incomeItem.amount,
            type = incomeItem.type,
            receivedDate = incomeItem.receivedDate
        )
        incomeDao.deleteIncome(entity)
    }

    override suspend fun deleteIncomesByDate(date: String) {
        incomeDao.deleteIncomesByDate(date)
    }

    override suspend fun deleteAllIncomes() {
        incomeDao.deleteAllIncomes()
    }
}