package com.inspirecoding.financeup.features.login.email.action

import com.inspirecoding.financeup.util.enums.loginstep.LoginStep

sealed class LoginEmailAction {
    data class OnEmailChanged(val email: String) : LoginEmailAction()
    data class SetCurrentStep(val step: LoginStep) : LoginEmailAction()
    data object ClearNavigation : LoginEmailAction()
    data object CheckEmail : LoginEmailAction()
}