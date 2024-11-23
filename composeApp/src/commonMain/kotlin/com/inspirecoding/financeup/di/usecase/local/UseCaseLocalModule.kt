package com.inspirecoding.financeup.di.usecase.local

import com.inspirecoding.financeup.domain.usecase.income.GetIncomeUseCase
import com.inspirecoding.financeup.domain.usecase.spending.GetSpendingUseCase
import org.koin.dsl.module

val useCaseLocalModule = module {
    factory { GetIncomeUseCase(incomeRepository = get()) }
    factory { GetSpendingUseCase(spendingRepository = get()) }
}