package com.inspirecoding.financeup.extensions

import androidx.compose.runtime.Composable
import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_NUMBER_SIX
import com.inspirecoding.financeup.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import com.inspirecoding.financeup.util.enums.inputtext.TextFieldState
import financeup.composeapp.generated.resources.Res
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
    val integerPart = this.toInt()
    val decimalPart = ((this - integerPart) * 100).toInt().let {
        if (it < 10) "0$it" else it.toString()
    }

    val formattedIntegerPart = integerPart
        .toString()
        .reversed()
        .chunked(3)
        .joinToString(".")
        .reversed()

    return "R$ $formattedIntegerPart,$decimalPart"
}

fun Float.toPercentage(): String {
    return "${(this * 100).toInt()}%"
}