package com.inspirecoding.financeup.features.login.secret.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.inspirecoding.financeup.extensions.isValidSecret
import com.inspirecoding.financeup.features.login.secret.action.LoginSecretAction
import com.inspirecoding.financeup.features.login.secret.state.LoginSecretState
import com.inspirecoding.financeup.navigation.routes.login.LoginRoutes
import com.inspirecoding.financeup.util.enums.inputtext.TextFieldState
import com.inspirecoding.financeup.util.enums.loginstep.LoginStep
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginSecretViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _state = MutableStateFlow(LoginSecretState())
    var state: StateFlow<LoginSecretState> = _state

    init {
        initData()
    }

    fun dispatchAction(action: LoginSecretAction) {
        when (action) {
            is LoginSecretAction.Login -> {
                login()
            }

            is LoginSecretAction.OnSecretChanged -> {
                onPasswordChanged(secret = action.secret)
            }
        }
    }

    private fun initData() {
        val email = savedStateHandle.toRoute<LoginRoutes.Secret>().email
        _state.update { it.copy(email = email) }

        setCurrentStep()
    }

    private fun login() {
        viewModelScope.launch {
            when (_state.value.secret.isValidSecret()) {
                TextFieldState.FILLED -> _state.update { it.copy(navigateToHomeScreen = true) }
                else -> _state.update { it.copy(secretFieldState = TextFieldState.ERROR) }
            }
        }
    }


    private fun onPasswordChanged(secret: String) {
        _state.update {
            it.copy(
                secret = secret,
                secretFieldState = TextFieldState.DEFAULT,
                errorMessage = null
            )
        }
    }

    private fun setCurrentStep() {
        viewModelScope.launch {
            delay(100)
            _state.update { it.copy(currentStep = LoginStep.LOGIN_SECRET.step) }
        }
    }
}