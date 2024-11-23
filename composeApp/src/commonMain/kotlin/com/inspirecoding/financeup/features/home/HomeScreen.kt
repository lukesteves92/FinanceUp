package com.inspirecoding.financeup.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.inspirecoding.financeup.extensions.formatCurrency
import com.inspirecoding.financeup.ui.components.background.FinanceUpDefaultBackground
import com.inspirecoding.financeup.ui.components.budget.BudgetProgressBar
import com.inspirecoding.financeup.ui.components.button.FloatingButtonUI
import com.inspirecoding.financeup.ui.components.expenses.ExpensesAndIncomes
import com.inspirecoding.financeup.ui.components.top.FinanceUpTopBar
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenLarge


@Composable
fun HomeScreen() {
    HomeContent()
}

@Composable
fun HomeContent() {

    val totalExpenses = remember { mutableStateOf(6650f) } // Gastos totais
    val totalIncomes = remember { mutableStateOf(8500f) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = {
            FinanceUpTopBar()
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .padding(financeUpDimenLarge)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                FloatingButtonUI(
                    isLess = true,
                    onClick = {}
                )

                FloatingButtonUI(
                    isAdd = true,
                    onClick = {}
                )
            }
        },
        floatingActionButton = {},
        content = { paddingValues ->

            FinanceUpDefaultBackground()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                ExpensesAndIncomes(
                    totalExpenses = { totalExpenses.value },
                    totalIncomes = { totalIncomes.value }
                )

                BudgetProgressBarExample()
            }
        }
    )
}

@Composable
fun BudgetProgressBarExample() {
    val totalBudget = remember { mutableStateOf(8000f) }
    val spentAmount = remember { mutableStateOf(8000f) }

    BudgetProgressBar(
        budget = totalBudget.value.formatCurrency(),
        spentAmount = { spentAmount.value },
        totalBudget = { totalBudget.value }
    )
}










