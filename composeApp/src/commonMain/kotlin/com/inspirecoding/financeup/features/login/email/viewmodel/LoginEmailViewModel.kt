package com.inspirecoding.financeup.features.login.email.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspirecoding.financeup.extensions.isValidEmail
import com.inspirecoding.financeup.features.login.email.action.LoginEmailAction
import com.inspirecoding.financeup.features.login.email.state.LoginEmailState
import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_DURATION_CURRENT_STEP_MIN
import com.inspirecoding.financeup.util.enums.inputtext.TextFieldState
import com.inspirecoding.financeup.util.enums.loginstep.LoginStep
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginEmailViewModel : ViewModel() {

    private var _state = MutableStateFlow(LoginEmailState())
    var state: StateFlow<LoginEmailState> = _state

    fun dispatchAction(action: LoginEmailAction) {
        when (action) {
            is LoginEmailAction.OnEmailChanged -> {
                onEmailChanged(email = action.email)
            }

            is LoginEmailAction.SetCurrentStep -> {
                setCurrentStep(step = action.step)
            }

            is LoginEmailAction.ClearNavigation -> {
                clearNavigation()
            }

            is LoginEmailAction.CheckEmail -> {
                checkEmail()
            }
        }
    }

    private fun checkEmail() {
        viewModelScope.launch {
            when (_state.value.email.isValidEmail()) {
                TextFieldState.FILLED -> _state.update { it.copy(navigateToPasswordScreen = true) }

                else -> _state.update { it.copy(emailFieldState = TextFieldState.ERROR) }
            }
        }
    }

    private fun onEmailChanged(email: String) {
        _state.update {
            it.copy(
                emailFieldState = TextFieldState.DEFAULT,
                email = email
            )
        }
    }

    private fun setCurrentStep(step: LoginStep) {
        viewModelScope.launch {
            delay(KEY_DURATION_CURRENT_STEP_MIN)
            _state.update { it.copy(currentStep = step.step) }
        }
    }

    private fun clearNavigation() {
        _state.update { it.copy(navigateToPasswordScreen = false) }
        setCurrentStep(step = LoginStep.LOGIN_PASSWORD)
    }
}