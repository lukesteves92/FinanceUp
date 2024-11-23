package com.inspirecoding.financeup.database.dao.spending

import androidx.room.*
import com.inspirecoding.financeup.database.entity.spending.SpendingEntity
import com.inspirecoding.financeup.util.constants.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface SpendingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpending(spending: SpendingEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpendings(spendings: List<SpendingEntity>)

    @Query("SELECT * FROM ${Constants.DataBase.SPENDING_TABLE} WHERE ${Constants.DataBase.PURCHASE_DATE_COLUMN_SPENDING_TABLE} = :date")
    fun getSpendingByDate(date: String): Flow<List<SpendingEntity>>

    @Query("SELECT * FROM ${Constants.DataBase.SPENDING_TABLE}")
    fun getAllSpendings(): Flow<List<SpendingEntity>>

    @Delete
    suspend fun deleteSpending(spending: SpendingEntity)

    @Query("DELETE FROM ${Constants.DataBase.SPENDING_TABLE} WHERE ${Constants.DataBase.PURCHASE_DATE_COLUMN_SPENDING_TABLE} = :date")
    suspend fun deleteSpendingsByDate(date: String)

    @Query("DELETE FROM ${Constants.DataBase.SPENDING_TABLE}")
    suspend fun deleteAllSpendings()
}
