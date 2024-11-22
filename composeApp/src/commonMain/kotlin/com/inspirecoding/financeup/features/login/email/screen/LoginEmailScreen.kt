package com.inspirecoding.financeup.features.login.email.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.inspirecoding.financeup.extensions.getErrorEmailMessage
import com.inspirecoding.financeup.features.login.email.state.LoginEmailState
import com.inspirecoding.financeup.features.login.email.viewmodel.LoginEmailViewModel
import com.inspirecoding.financeup.features.login.email.action.LoginEmailAction
import com.inspirecoding.financeup.ui.components.background.FinanceUpDefaultBackground
import com.inspirecoding.financeup.ui.components.button.FloatingButtonUI
import com.inspirecoding.financeup.ui.components.header.HeaderScreen
import com.inspirecoding.financeup.ui.components.indicator.PagerIndicator
import com.inspirecoding.financeup.ui.components.input.InputTextField
import com.inspirecoding.financeup.ui.components.top.FinanceUpTopBar
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.util.enums.loginstep.LoginStep
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimen3XLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimen4XLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenLarge
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.label_input_email
import financeup.composeapp.generated.resources.text_subtitle_login_email_screen
import financeup.composeapp.generated.resources.text_title_login_email_screen
import financeup.composeapp.generated.resources.text_title_top_app_bar_login_email_screen
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginEmailScreen(
    navigateToLoginPasswordScreen: (String) -> Unit,
    onBackPressed: () -> Unit
) {
    val viewModel = koinViewModel<LoginEmailViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LifecycleEventEffect(event = Lifecycle.Event.ON_START) {
        viewModel.dispatchAction(LoginEmailAction.SetCurrentStep(LoginStep.LOGIN_EMAIL))
    }

    LaunchedEffect(state.navigateToPasswordScreen) {
        if (state.navigateToPasswordScreen) {
            navigateToLoginPasswordScreen(state.email)
            viewModel.dispatchAction(LoginEmailAction.ClearNavigation)
        }
    }

    LoginEmailContent(
        state = state,
        action = viewModel::dispatchAction,
        onBackPressed = onBackPressed
    )
}

@Composable
private fun LoginEmailContent(
    state: LoginEmailState,
    action: (LoginEmailAction) -> Unit,
    onBackPressed: () -> Unit
) {

    Scaffold(
        topBar = {
            FinanceUpTopBar(
                navigationText = stringResource(Res.string.text_title_top_app_bar_login_email_screen),
                onClick = onBackPressed
            )
        },
        floatingActionButton = {
            FloatingButtonUI(
                onClick = { action(LoginEmailAction.CheckEmail) }
            )
        },
        containerColor = Color.Transparent,
        content = { paddingValues ->

            FinanceUpDefaultBackground()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = financeUpDimenLarge)
            ) {

                Spacer(modifier = Modifier.height(financeUpDimen3XLarge))


                PagerIndicator(
                    indicatorSize = LoginStep.entries.size,
                    currentIndicator = state.currentStep
                )

                HeaderScreen(
                    modifier = Modifier
                        .padding(
                            top = financeUpDimen3XLarge,
                            bottom = financeUpDimen4XLarge
                        ),
                    title = stringResource(Res.string.text_title_login_email_screen),
                    subTitle = stringResource(Res.string.text_subtitle_login_email_screen)
                )

                InputTextField(
                    text = state.email,
                    label = stringResource(Res.string.label_input_email),
                    errorMessage = state.emailFieldState.getErrorEmailMessage(),
                    state = state.emailFieldState,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    onTextChange = {
                        action(LoginEmailAction.OnEmailChanged(it))
                    }
                )
            }
        }
    )
}

@Preview
@Composable
private fun LoginEmailPreview() {
    FinanceUpTheme {
        LoginEmailContent(
            state = LoginEmailState(),
            action = {},
            onBackPressed = {}
        )
    }
}