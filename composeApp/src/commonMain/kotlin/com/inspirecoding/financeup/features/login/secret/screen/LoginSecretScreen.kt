package com.inspirecoding.financeup.features.login.secret.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.inspirecoding.financeup.extensions.getErrorSecretMessage
import com.inspirecoding.financeup.features.login.secret.state.LoginSecretState
import com.inspirecoding.financeup.features.login.secret.viewmodel.LoginSecretViewModel
import com.inspirecoding.financeup.features.login.secret.action.LoginSecretAction
import com.inspirecoding.financeup.ui.components.background.FinanceUpDefaultBackground
import com.inspirecoding.financeup.ui.components.button.FloatingButtonUI
import com.inspirecoding.financeup.ui.components.header.HeaderScreen
import com.inspirecoding.financeup.ui.components.indicator.PagerIndicator
import com.inspirecoding.financeup.ui.components.input.SecretTextField
import com.inspirecoding.financeup.ui.components.top.FinanceUpTopBar
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.util.enums.loginstep.LoginStep
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimen3XLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimen4XLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenLarge
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.label_input_secret
import financeup.composeapp.generated.resources.text_subtitle_login_secret_screen
import financeup.composeapp.generated.resources.text_title_login_secret_screen
import financeup.composeapp.generated.resources.text_title_top_app_bar_login_secret_screen
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginSecretScreen(
    navigateToHomeScreen: () -> Unit,
    onBackPressed: () -> Unit
) {
    val viewModel = koinViewModel<LoginSecretViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(state.navigateToHomeScreen) {
        if (state.navigateToHomeScreen) {
            navigateToHomeScreen()
        }
    }

    LoginSecretContent(
        state = state,
        action = viewModel::dispatchAction,
        onBackPressed = onBackPressed
    )
}

@Composable
private fun LoginSecretContent(
    state: LoginSecretState,
    action: (LoginSecretAction) -> Unit,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            FinanceUpTopBar(
                navigationText = stringResource(Res.string.text_title_top_app_bar_login_secret_screen),
                onClick = onBackPressed
            )
        },
        floatingActionButton = {
            FloatingButtonUI(
                onClick = {
                    action(LoginSecretAction.Login)
                }
            )
        },
        containerColor = Color.Transparent,
        content = { paddingValues ->

            FinanceUpDefaultBackground()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
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
                    title = stringResource(Res.string.text_title_login_secret_screen),
                    subTitle = stringResource(Res.string.text_subtitle_login_secret_screen)
                )

                SecretTextField(
                    text = state.secret,
                    label = stringResource(Res.string.label_input_secret),
                    errorMessage = state.errorMessage
                        ?: state.secretFieldState.getErrorSecretMessage(),
                    state = state.secretFieldState,
                    onTextChange = {
                        action(LoginSecretAction.OnSecretChanged(it))
                    }
                )
            }
        }
    )
}

@Preview
@Composable
private fun LoginPasswordPreview() {
    FinanceUpTheme {
        LoginSecretContent(
            state = LoginSecretState(),
            action = {},
            onBackPressed = {}
        )
    }
}