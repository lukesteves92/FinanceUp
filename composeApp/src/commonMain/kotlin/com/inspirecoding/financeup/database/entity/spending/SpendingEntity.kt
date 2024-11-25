package com.inspirecoding.financeup.database.entity.spending

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.inspirecoding.financeup.util.constants.Constants.DataBase.AMOUNT_COLUMN_SPENDING_TABLE
import com.inspirecoding.financeup.util.constants.Constants.DataBase.ID_COLUMN_SPENDING_TABLE
import com.inspirecoding.financeup.util.constants.Constants.DataBase.NAME_COLUMN_SPENDING_TABLE
import com.inspirecoding.financeup.util.constants.Constants.DataBase.PURCHASE_DATE_COLUMN_SPENDING_TABLE
import com.inspirecoding.financeup.util.constants.Constants.DataBase.SPENDING_TABLE
import com.inspirecoding.financeup.util.constants.Constants.DataBase.TYPE_COLUMN_SPENDING_TABLE
import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_NUMBER_ZERO_LONG

@Entity(tableName = SPENDING_TABLE)
data class SpendingEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID_COLUMN_SPENDING_TABLE)
    val id: Long = KEY_NUMBER_ZERO_LONG,

    @ColumnInfo(name = NAME_COLUMN_SPENDING_TABLE)
    val name: String,

    @ColumnInfo(name = AMOUNT_COLUMN_SPENDING_TABLE)
    val amount: Float,

    @ColumnInfo(name = TYPE_COLUMN_SPENDING_TABLE)
    val type: String,

    @ColumnInfo(name = PURCHASE_DATE_COLUMN_SPENDING_TABLE)
    val purchaseDate: String
)