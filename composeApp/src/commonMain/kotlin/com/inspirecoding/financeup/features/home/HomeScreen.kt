package com.inspirecoding.financeup.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.inspirecoding.financeup.model.IncomeItem
import com.inspirecoding.financeup.model.SpendingItem
import com.inspirecoding.financeup.ui.components.background.FinanceUpDefaultBackground
import com.inspirecoding.financeup.ui.components.budget.BudgetProgressBar
import com.inspirecoding.financeup.ui.components.expenses.ExpensesAndIncomes
import com.inspirecoding.financeup.ui.components.income.section.IncomeSection
import com.inspirecoding.financeup.ui.components.spending.section.SpendingSection
import com.inspirecoding.financeup.ui.components.top.FinanceUpTopBar
import com.inspirecoding.financeup.util.enums.expensetype.ExpenseType
import com.inspirecoding.financeup.util.enums.incometype.IncomeType


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
        bottomBar = {},
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

                BudgetProgressBar(
                    budget = totalIncomes.value.formatCurrency(),
                    spentAmount = { totalExpenses.value },
                    totalBudget = { totalIncomes.value }
                )

                SpendingBreakdownScreen()

                IncomeBreakdownScreen()
            }
        }
    )
}

@Composable
fun SpendingBreakdownScreen() {
    val spendingItems = listOf(
        SpendingItem(
            name = "Almoço",
            amount = 120f,
            type = ExpenseType.FOOD,
            purchaseDate = "Outubro/2024"
        ),
        SpendingItem(
            name = "Compras",
            amount = 350f,
            type = ExpenseType.SHOPPING,
            purchaseDate = "Outubro/2024"
        ),
        SpendingItem(
            name = "Aluguel",
            amount = 1500f,
            type = ExpenseType.RENT,
            purchaseDate = "Setembro/2024"
        ),
        SpendingItem(
            name = "Cinema",
            amount = 45f,
            type = ExpenseType.LEISURE,
            purchaseDate = "Setembro/2024"
        ),
        SpendingItem(
            name = "Outros",
            amount = 80f,
            type = ExpenseType.OTHERS,
            purchaseDate = "Agosto/2024"
        )
    )

    SpendingSection(
        spendingItems = spendingItems,
        modifier = Modifier.fillMaxSize()
    )
}


@Composable
fun IncomeBreakdownScreen() {
    val incomeItems = listOf(
        IncomeItem(
            name = "Salário",
            amount = 5000f,
            type = IncomeType.SALARY,
            receivedDate = "Outubro/2024"
        ),
        IncomeItem(
            name = "Rendimentos",
            amount = 1200f,
            type = IncomeType.EARNINGS,
            receivedDate = "Setembro/2024"
        ),
        IncomeItem(
            name = "Outros",
            amount = 350f,
            type = IncomeType.OTHERS,
            receivedDate = "Agosto/2024"
        )
    )

    IncomeSection(
        incomeItems = incomeItems,
        modifier = Modifier.fillMaxSize()
    )
}

















