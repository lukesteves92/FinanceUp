package com.inspirecoding.financeup.extensions

import androidx.compose.runtime.Composable
import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_NUMBER_SIX
import com.inspirecoding.financeup.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import com.inspirecoding.financeup.util.enums.expensetype.ExpenseType
import com.inspirecoding.financeup.util.enums.incometype.IncomeType
import com.inspirecoding.financeup.util.enums.inputtext.TextFieldState
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.expense_food
import financeup.composeapp.generated.resources.expense_leisure
import financeup.composeapp.generated.resources.expense_others
import financeup.composeapp.generated.resources.expense_rent
import financeup.composeapp.generated.resources.expense_shopping
import financeup.composeapp.generated.resources.income_earnings
import financeup.composeapp.generated.resources.income_others
import financeup.composeapp.generated.resources.income_salary
import financeup.composeapp.generated.resources.message_email_invalid_format
import financeup.composeapp.generated.resources.message_password_invalid_format
import org.jetbrains.compose.resources.stringResource

@Composable
fun TextFieldState.getErrorEmailMessage(): String {
    return when (this) {
        TextFieldState.DEFAULT,
        TextFieldState.ERROR -> {
            stringResource(Res.string.message_email_invalid_format)
        }

        else -> EMPTY_STRING_DEFAULT
    }
}

fun String.isValidEmail(): TextFieldState {
    val emailRegex = "^[A-Za-z](.*)([@])(.+)(\\.)(.+)"
    return when {
        this.trim().isEmpty() -> TextFieldState.DEFAULT
        this.trim().matches(emailRegex.toRegex()) -> TextFieldState.FILLED
        else -> TextFieldState.ERROR
    }
}

@Composable
fun TextFieldState.getErrorSecretMessage(): String {
    return when (this) {
        TextFieldState.ERROR -> {
            stringResource(Res.string.message_password_invalid_format)
        }

        else -> EMPTY_STRING_DEFAULT
    }
}

fun String.isValidSecret(): TextFieldState {
    return when {
        this.length >= KEY_NUMBER_SIX -> TextFieldState.FILLED
        else -> TextFieldState.ERROR
    }
}

fun Float.formatCurrency(): String {
    val isNegative = this < 0
    val absoluteValue = kotlin.math.abs(this)

    val integerPart = absoluteValue.toInt()
    val decimalPart = ((absoluteValue - integerPart) * 100).toInt().let {
        if (it < 10) "0$it" else it.toString()
    }

    val formattedIntegerPart = integerPart
        .toString()
        .reversed()
        .chunked(3)
        .joinToString(".")
        .reversed()

    return if (isNegative) {
        "R$ -$formattedIntegerPart,$decimalPart"
    } else {
        "R$ $formattedIntegerPart,$decimalPart"
    }
}

fun String.toRawAmount(): Float {
    return this.replace("[^\\d]".toRegex(), "").toFloatOrNull()?.div(100) ?: 0f
}

fun Float.toPercentage(): String {
    return "${(this * 100).toInt()}%"
}

@Composable
fun IncomeType.displayName(): String {
    return when (this) {
        IncomeType.SALARY -> stringResource(Res.string.income_salary)
        IncomeType.EARNINGS -> stringResource(Res.string.income_earnings)
        IncomeType.OTHERS -> stringResource(Res.string.income_others)
    }
}
@Composable
fun ExpenseType.displayName(): String {
    return when (this) {
        ExpenseType.FOOD -> stringResource(Res.string.expense_food)
        ExpenseType.SHOPPING -> stringResource(Res.string.expense_shopping)
        ExpenseType.RENT -> stringResource(Res.string.expense_rent)
        ExpenseType.LEISURE -> stringResource(Res.string.expense_leisure)
        ExpenseType.OTHERS -> stringResource(Res.string.expense_others)
    }
}