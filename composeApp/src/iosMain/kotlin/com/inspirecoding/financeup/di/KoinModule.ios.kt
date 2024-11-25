package com.inspirecoding.financeup.di

import com.inspirecoding.financeup.database.getDatabaseBuilder
import org.koin.dsl.module

actual val targetModule = module {
    single {
        getDatabaseBuilder()
    }
}