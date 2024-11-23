package com.inspirecoding.financeup.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.inspirecoding.financeup.database.db.FinanceUpDatabase
import com.inspirecoding.financeup.util.constants.Constants.DataBase.FINANCE_UP_DATABASE

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<FinanceUpDatabase> {
    val dbFile = context.getDatabasePath(FINANCE_UP_DATABASE)
    return Room.databaseBuilder(
        context = context,
        name = dbFile.absolutePath
    )
}