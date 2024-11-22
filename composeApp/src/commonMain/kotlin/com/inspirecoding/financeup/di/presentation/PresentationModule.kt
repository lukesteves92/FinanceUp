package com.inspirecoding.financeup.di.presentation

import com.inspirecoding.financeup.features.login.email.viewmodel.LoginEmailViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {

    // Authentication
    viewModelOf(::LoginEmailViewModel)
}