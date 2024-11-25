package com.inspirecoding.financeup.di.usecase

import com.inspirecoding.financeup.domain.usecase.income.GetIncomeUseCase
import com.inspirecoding.financeup.domain.usecase.spending.GetSpendingUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseLocalModule = module {
    factoryOf(::GetIncomeUseCase)
    factoryOf(::GetSpendingUseCase)
}