package com.inspirecoding.financeup.main

import androidx.compose.ui.window.ComposeUIViewController
import com.inspirecoding.financeup.di.initializeKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initializeKoin() }
) { App() }