package com.inspirecoding.financeup.database.dao.income

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.inspirecoding.financeup.database.entity.income.IncomeEntity
import com.inspirecoding.financeup.util.constants.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface IncomeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIncome(income: IncomeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIncomes(incomes: List<IncomeEntity>)

    @Query("SELECT * FROM ${Constants.DataBase.INCOME_TABLE} WHERE ${Constants.DataBase.RECEIVED_DATE_COLUMN_INCOME_TABLE} = :date")
    fun getIncomeByDate(date: String): Flow<List<IncomeEntity>>

    @Query("SELECT * FROM ${Constants.DataBase.INCOME_TABLE}")
    fun getAllIncomes(): Flow<List<IncomeEntity>>

    @Delete
    suspend fun deleteIncome(income: IncomeEntity)

    @Query("DELETE FROM ${Constants.DataBase.INCOME_TABLE} WHERE ${Constants.DataBase.RECEIVED_DATE_COLUMN_INCOME_TABLE} = :date")
    suspend fun deleteIncomesByDate(date: String)

    @Query("DELETE FROM ${Constants.DataBase.INCOME_TABLE}")
    suspend fun deleteAllIncomes()
}