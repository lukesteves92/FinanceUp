package com.inspirecoding.financeup.features.login.secret.state

import com.inspirecoding.financeup.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import com.inspirecoding.financeup.util.enums.inputtext.TextFieldState
import com.inspirecoding.financeup.util.enums.loginstep.LoginStep

data class LoginSecretState(
    val email: String = EMPTY_STRING_DEFAULT,
    val secret: String = EMPTY_STRING_DEFAULT,
    val secretFieldState: TextFieldState = TextFieldState.DEFAULT,
    val currentStep: Int = LoginStep.LOGIN_EMAIL.step,
    val navigateToHomeScreen: Boolean = false,
    val errorMessage: String? = null
)
