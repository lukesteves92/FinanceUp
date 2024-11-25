package com.inspirecoding.financeup.di.data

import com.inspirecoding.financeup.data.income.IncomeRepositoryImpl
import com.inspirecoding.financeup.data.spending.SpendingRepositoryImpl
import com.inspirecoding.financeup.database.db.FinanceUpDatabase
import com.inspirecoding.financeup.domain.repository.income.IncomeRepository
import com.inspirecoding.financeup.domain.repository.spending.SpendingRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    single { get<FinanceUpDatabase>().incomeDao() }
    single { get<FinanceUpDatabase>().spendingDao() }
    factoryOf(::IncomeRepositoryImpl).bind(IncomeRepository::class)
    factoryOf(::SpendingRepositoryImpl).bind(SpendingRepository::class)
}