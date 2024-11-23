package com.inspirecoding.financeup.di

import com.inspirecoding.financeup.di.data.dataModule
import com.inspirecoding.financeup.di.network.networkModule
import com.inspirecoding.financeup.di.presentation.presentationModule
import com.inspirecoding.financeup.di.usecase.local.useCaseLocalModule
import com.inspirecoding.financeup.di.usecase.remote.useCaseRemoteModule
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
            networkModule,
            useCaseRemoteModule,
            useCaseLocalModule
        )
    }
}