package com.inspirecoding.financeup.database.entity.income

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import com.inspirecoding.financeup.util.constants.Constants.DataBase.AMOUNT_COLUMN_INCOME_TABLE
import com.inspirecoding.financeup.util.constants.Constants.DataBase.ID_COLUMN_INCOME_TABLE
import com.inspirecoding.financeup.util.constants.Constants.DataBase.INCOME_TABLE
import com.inspirecoding.financeup.util.constants.Constants.DataBase.NAME_COLUMN_INCOME_TABLE
import com.inspirecoding.financeup.util.constants.Constants.DataBase.RECEIVED_DATE_COLUMN_INCOME_TABLE
import com.inspirecoding.financeup.util.constants.Constants.DataBase.TYPE_COLUMN_INCOME_TABLE
import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_NUMBER_ZERO_LONG

@Entity(tableName = INCOME_TABLE)
data class IncomeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID_COLUMN_INCOME_TABLE)
    val id: Long = KEY_NUMBER_ZERO_LONG,

    @ColumnInfo(name = NAME_COLUMN_INCOME_TABLE)
    val name: String,

    @ColumnInfo(name = AMOUNT_COLUMN_INCOME_TABLE)
    val amount: Float,

    @ColumnInfo(name = TYPE_COLUMN_INCOME_TABLE)
    val type: String,

    @ColumnInfo(name = RECEIVED_DATE_COLUMN_INCOME_TABLE)
    val receivedDate: String
)