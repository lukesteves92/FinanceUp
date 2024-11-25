package com.inspirecoding.financeup.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspirecoding.financeup.domain.usecase.income.GetIncomeUseCase
import com.inspirecoding.financeup.domain.usecase.spending.GetSpendingUseCase
import com.inspirecoding.financeup.features.home.action.HomeAction
import com.inspirecoding.financeup.features.home.state.HomeState
import com.inspirecoding.financeup.model.income.IncomeItem
import com.inspirecoding.financeup.model.spending.SpendingItem
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getIncomeUseCase: GetIncomeUseCase,
    private val getSpendingUseCase: GetSpendingUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    private val pendingActions = MutableSharedFlow<HomeAction>()

    init {
        handleActions()
    }

    private fun handleActions() {
        viewModelScope.launch {
            pendingActions.collect { action ->
                when (action) {
                    is HomeAction.AddIncome -> addIncome(action.incomeItem)
                    is HomeAction.AddSpending -> addSpending(action.spendingItem)
                    is HomeAction.DeleteIncome -> deleteIncome(action.incomeItem)
                    is HomeAction.DeleteSpending -> deleteSpending(action.spendingItem)
                    is HomeAction.UpdateSelectedDate -> updateSelectedDate(action.date)
                    is HomeAction.LoadInitialData -> loadInitialData()
                }
            }
        }
    }

    fun submitAction(action: HomeAction) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

    private fun addIncome(incomeItem: IncomeItem) {
        viewModelScope.launch {
            getIncomeUseCase.insertIncome(incomeItem)
            loadInitialData()
        }
    }

    private fun addSpending(spendingItem: SpendingItem) {
        viewModelScope.launch {
            getSpendingUseCase.insertSpending(spendingItem)
            loadInitialData()
        }
    }

    private fun deleteIncome(incomeItem: IncomeItem) {
        viewModelScope.launch {
            getIncomeUseCase.deleteIncome(incomeItem)
            loadInitialData()
        }
    }

    private fun deleteSpending(spendingItem: SpendingItem) {
        viewModelScope.launch {
            getSpendingUseCase.deleteSpending(spendingItem)
            loadInitialData()
        }
    }

    private fun updateSelectedDate(date: String) {
        viewModelScope.launch {
            getIncomeUseCase.getIncomeByDate(date)
                .combineWith(getSpendingUseCase.getSpendingByDate(date)) { incomes, spendings ->
                    _state.update { currentState ->
                        currentState.copy(
                            currentSelectedDate = date,
                            incomeItems = incomes,
                            spendingItems = spendings
                        )
                    }
                    loadInitialData()
                }
        }
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            getIncomeUseCase.getAllIncomes()
                .combineWith(getSpendingUseCase.getAllSpendings()) { allIncomes, allSpendings ->
                    _state.update { currentState ->
                        currentState.copy(
                            incomeItems = allIncomes,
                            spendingItems = allSpendings,
                            currentSelectedDate = currentState.currentSelectedDate.ifEmpty {
                                (allIncomes.map { it.receivedDate } + allSpendings.map { it.purchaseDate })
                                    .distinct()
                                    .maxOrNull()
                                    .orEmpty()
                            }
                        )
                    }
                }
        }
    }

    private suspend fun <T, U> Flow<T>.combineWith(
        other: Flow<U>,
        action: suspend (T, U) -> Unit
    ) = combine(other) { t, u -> t to u }
        .collect { (t, u) -> action(t, u) }
}