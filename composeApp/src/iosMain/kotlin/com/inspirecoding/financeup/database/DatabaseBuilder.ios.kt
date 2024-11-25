package com.inspirecoding.financeup.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.inspirecoding.financeup.database.db.FinanceUpDatabase
import com.inspirecoding.financeup.util.constants.Constants.DataBase.FINANCE_UP_DATABASE
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

fun getDatabaseBuilder(): RoomDatabase.Builder<FinanceUpDatabase> {
    val dbFilePath = documentDirectory() + "/$FINANCE_UP_DATABASE"
    return Room.databaseBuilder<FinanceUpDatabase>(
        name = dbFilePath
    )
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}