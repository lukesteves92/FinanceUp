package com.inspirecoding.financeup.features.home.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.inspirecoding.financeup.features.home.action.HomeAction
import com.inspirecoding.financeup.features.home.state.HomeState
import com.inspirecoding.financeup.features.home.viewmodel.HomeViewModel
import com.inspirecoding.financeup.model.income.IncomeItem
import com.inspirecoding.financeup.model.spending.SpendingItem
import com.inspirecoding.financeup.ui.components.background.FinanceUpDefaultBackground
import com.inspirecoding.financeup.ui.components.bottomsheet.main.FinanceUpBottomSheet
import com.inspirecoding.financeup.ui.components.budget.BudgetProgressBar
import com.inspirecoding.financeup.ui.components.expenses.ExpensesAndIncomes
import com.inspirecoding.financeup.ui.components.income.section.IncomeSection
import com.inspirecoding.financeup.ui.components.spending.section.SpendingSection
import com.inspirecoding.financeup.ui.components.top.FinanceUpTopBar
import com.inspirecoding.financeup.util.enums.sheet.DefaultSheetType
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun HomeScreen() {

    val viewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LifecycleEventEffect(event = Lifecycle.Event.ON_START) {
        viewModel.submitAction(HomeAction.LoadInitialData)
    }

    HomeContent(
        state = state,
        onAction = { action -> viewModel.submitAction(action) }
    )
}

@Composable
fun HomeContent(
    state: HomeState,
    onAction: (HomeAction) -> Unit
) {
    val isSheetOpen = rememberSaveable { mutableStateOf(false) }
    val defaultSheetType = remember { mutableStateOf(DefaultSheetType.INCOME) }


    FinanceUpBottomSheet(
        isSheetOpen = isSheetOpen.value,
        onDismissRequest = { condition -> isSheetOpen.value = condition },
        type = defaultSheetType.value,
        onAddIncomeClick = { income, condition ->
            onAction(HomeAction.AddIncome(income))
            isSheetOpen.value = condition
        },
        onAddExpenseClick = { expense, condition ->
            onAction(HomeAction.AddSpending(expense))
            isSheetOpen.value = condition
        }
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = { FinanceUpTopBar() },
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
                    totalExpenses = { state.totalExpenses },
                    totalIncomes = { state.totalIncomes },
                    selectedDate = { state.currentSelectedDate },
                    onDateChange = { newDate ->
                        onAction(HomeAction.UpdateSelectedDate(newDate))
                    },
                    availableDates = { state.availableDates }
                )

                BudgetProgressBar(
                    spentAmount = { state.totalExpenses },
                    totalBudget = { state.totalIncomes }
                )

                SpendingBreakdownScreen(
                    spendingItems = state.filteredSpendingItems,
                    onDeleteItem = { item ->
                        onAction(HomeAction.DeleteSpending(item))
                    },
                    isAddItem = {
                        defaultSheetType.value = DefaultSheetType.EXPENSE
                        isSheetOpen.value = true
                    }
                )

                IncomeBreakdownScreen(
                    incomeItems = state.filteredIncomeItems,
                    onDeleteItem = { item ->
                        onAction(HomeAction.DeleteIncome(item))
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
    isAddItem: () -> Unit
) {
    IncomeSection(
        incomeItemsProvider = { incomeItems },
        modifier = Modifier.fillMaxSize(),
        isAddItem = isAddItem,
        onDeleteItem = onDeleteItem
    )
}