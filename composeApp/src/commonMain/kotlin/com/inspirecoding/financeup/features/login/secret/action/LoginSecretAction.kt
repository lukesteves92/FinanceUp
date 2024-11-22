package com.inspirecoding.financeup.features.login.secret.action

sealed interface LoginSecretAction {
    data class OnSecretChanged(val secret: String) : LoginSecretAction
    data object Login : LoginSecretAction
}