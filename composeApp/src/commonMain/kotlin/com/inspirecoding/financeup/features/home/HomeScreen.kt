package com.inspirecoding.financeup.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.inspirecoding.financeup.model.IncomeItem
import com.inspirecoding.financeup.model.SpendingItem
import com.inspirecoding.financeup.ui.components.background.FinanceUpDefaultBackground
import com.inspirecoding.financeup.ui.components.bottomsheet.main.FinanceUpBottomSheet
import com.inspirecoding.financeup.ui.components.budget.BudgetProgressBar
import com.inspirecoding.financeup.ui.components.expenses.ExpensesAndIncomes
import com.inspirecoding.financeup.ui.components.income.section.IncomeSection
import com.inspirecoding.financeup.ui.components.spending.section.SpendingSection
import com.inspirecoding.financeup.ui.components.top.FinanceUpTopBar
import com.inspirecoding.financeup.util.enums.expensetype.ExpenseType
import com.inspirecoding.financeup.util.enums.incometype.IncomeType
import com.inspirecoding.financeup.util.enums.sheet.DefaultSheetType


@Composable
fun HomeScreen() {
    HomeContent()
}

@Composable
fun HomeContent() {
    val isSheetOpen = rememberSaveable { mutableStateOf(false) }
    val defaultSheetType = remember { mutableStateOf(DefaultSheetType.INCOME) }
    var currentSelectedDate by remember { mutableStateOf("Novembro/2024") }
    val spendingItems = remember {
        mutableStateListOf(
            SpendingItem("Almoço", 120f, ExpenseType.FOOD, "Novembro/2024"),
            SpendingItem("Compras", 350f, ExpenseType.SHOPPING, "Outubro/2024"),
            SpendingItem("Aluguel", 1500f, ExpenseType.RENT, "Setembro/2024"),
            SpendingItem("Cinema", 45f, ExpenseType.LEISURE, "Setembro/2024"),
            SpendingItem("Outros", 80f, ExpenseType.OTHERS, "Agosto/2024")
        )
    }
    val incomeItems = remember {
        mutableStateListOf(
            IncomeItem("Salário", 5000f, IncomeType.SALARY, "Novembro/2024"),
            IncomeItem("Rendimentos", 1200f, IncomeType.EARNINGS, "Outubro/2024"),
            IncomeItem("Outros", 350f, IncomeType.OTHERS, "Agosto/2024")
        )
    }

    val availableDates by derivedStateOf {
        (spendingItems.map { it.purchaseDate } + incomeItems.map { it.receivedDate })
            .distinct()
            .sortedDescending()
    }

    val filteredSpendingItems by derivedStateOf {
        spendingItems.filter { it.purchaseDate == currentSelectedDate }
    }
    val filteredIncomeItems by derivedStateOf {
        incomeItems.filter { it.receivedDate == currentSelectedDate }
    }

    val totalExpenses by derivedStateOf {
        filteredSpendingItems.sumOf { it.amount.toDouble() }.toFloat()
    }

    val totalIncomes by derivedStateOf {
        filteredIncomeItems.sumOf { it.amount.toDouble() }.toFloat()
    }

    FinanceUpBottomSheet(
        isSheetOpen = isSheetOpen.value,
        onDismissRequest = { condition -> isSheetOpen.value = condition },
        type = defaultSheetType.value,
        onAddIncomeClick = { income, condition ->
            incomeItems.add(income)
            if (income.receivedDate == currentSelectedDate) {
                currentSelectedDate = income.receivedDate
            }
            isSheetOpen.value = condition
        },
        onAddExpenseClick = { expense, condition ->
            spendingItems.add(expense)
            if (expense.purchaseDate == currentSelectedDate) {
                currentSelectedDate = expense.purchaseDate
            }
            isSheetOpen.value = condition
        }
    )

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
                // Seção de Gastos e Receitas
                ExpensesAndIncomes(
                    totalExpenses = { totalExpenses },
                    totalIncomes = { totalIncomes },
                    selectedDate = { currentSelectedDate },
                    onDateChange = { newDate ->
                        currentSelectedDate = newDate
                    },
                    availableDates = { availableDates }
                )

                // Barra de Progresso do Orçamento
                BudgetProgressBar(
                    spentAmount = { totalExpenses },
                    totalBudget = { totalIncomes }
                )

                // Lista de Gastos
                SpendingBreakdownScreen(
                    spendingItems = filteredSpendingItems,
                    onDeleteItem = { item ->
                        spendingItems.remove(item)
                    },
                    isAddItem = {
                        defaultSheetType.value = DefaultSheetType.EXPENSE
                        isSheetOpen.value = true
                    }
                )

                // Lista de Receitas
                IncomeBreakdownScreen(
                    incomeItems = filteredIncomeItems,
                    onDeleteItem = { item ->
                        incomeItems.remove(item)
                    },
                    isAddItem = {
                        defaultSheetType.value = DefaultSheetType.INCOME
                        isSheetOpen.value = true
                    }
                )
            }
        }
    )
}

@Composable
fun SpendingBreakdownScreen(
    spendingItems: List<SpendingItem>,
    onDeleteItem: (SpendingItem) -> Unit,
    isAddItem: () -> Unit
) {
    SpendingSection(
        spendingItemsProvider = { spendingItems },
        modifier = Modifier.fillMaxSize(),
        isAddItem = isAddItem,
        onDeleteItem = onDeleteItem
    )
}

@Composable
fun IncomeBreakdownScreen(
    incomeItems: List<IncomeItem>,
    onDeleteItem: (IncomeItem) -> Unit,
    isAddItem: () -> Unit,
) {
    IncomeSection(
        incomeItemsProvider = { incomeItems },
        modifier = Modifier.fillMaxSize(),
        isAddItem = isAddItem,
        onDeleteItem = onDeleteItem
    )
}


















