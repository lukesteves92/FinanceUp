package com.inspirecoding.financeup.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.inspirecoding.financeup.ui.components.background.FinanceUpDefaultBackground
import com.inspirecoding.financeup.ui.components.top.FinanceUpTopBar

@Composable
fun HomeScreen() {
    HomeContent()
}

@Composable
fun HomeContent() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = {
            FinanceUpTopBar()
        },
        bottomBar = {},
        floatingActionButton = {},
        content = { paddingValues ->

            FinanceUpDefaultBackground()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.Start
            ) {}
        }
    )
}