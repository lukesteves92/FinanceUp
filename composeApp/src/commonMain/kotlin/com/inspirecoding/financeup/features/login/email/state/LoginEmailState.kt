package com.inspirecoding.financeup.features.login.email.state

import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_NUMBER_ZERO
import com.inspirecoding.financeup.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import com.inspirecoding.financeup.util.enums.inputtext.TextFieldState

data class LoginEmailState(
    val email: String = EMPTY_STRING_DEFAULT,
    val emailFieldState: TextFieldState = TextFieldState.DEFAULT,
    val emailInputError: String = EMPTY_STRING_DEFAULT,
    val currentStep: Int = KEY_NUMBER_ZERO,
    val navigateToPasswordScreen: Boolean = false
)