package com.inspirecoding.financeup.di

import com.inspirecoding.financeup.di.data.dataModule
import com.inspirecoding.financeup.di.presentation.presentationModule
import com.inspirecoding.financeup.di.usecase.useCaseLocalModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

expect val targetModule: Module

fun initializeKoin(
    config: (KoinApplication.() -> Unit)? = null
) {
    startKoin {
        config?.invoke(this)
        modules(
            targetModule,
            presentationModule,
            dataModule,
            useCaseLocalModule
        )
    }
}