package com.inspirecoding.financeup.extensions

import androidx.compose.runtime.Composable
import com.inspirecoding.financeup.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import com.inspirecoding.financeup.util.enums.inputtext.TextFieldState
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.message_email_invalid_format
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