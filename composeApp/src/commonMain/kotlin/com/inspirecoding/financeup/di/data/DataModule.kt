package com.inspirecoding.financeup.di.data

import com.inspirecoding.financeup.data.income.IncomeRepositoryImpl
import com.inspirecoding.financeup.data.spending.SpendingRepositoryImpl
import com.inspirecoding.financeup.domain.repository.income.IncomeRepository
import com.inspirecoding.financeup.domain.repository.spending.SpendingRepository
import org.koin.dsl.module

val dataModule = module {
    single<IncomeRepository> { IncomeRepositoryImpl(database = get()) }
    single<SpendingRepository> { SpendingRepositoryImpl(database = get()) }
}