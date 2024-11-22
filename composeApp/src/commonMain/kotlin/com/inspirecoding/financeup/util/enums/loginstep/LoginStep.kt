package com.inspirecoding.financeup.util.enums.loginstep

import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_NUMBER_ONE
import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_NUMBER_TWO

enum class LoginStep(val step: Int) {
    LOGIN_EMAIL(KEY_NUMBER_ONE),
    LOGIN_SECRET(KEY_NUMBER_TWO)
}