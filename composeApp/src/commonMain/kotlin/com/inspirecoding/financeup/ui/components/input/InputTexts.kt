package com.inspirecoding.financeup.ui.components.input

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import com.inspirecoding.financeup.ui.color.FinanceUpColorBaselineWhite
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.ui.typography.FinanceUpTypography
import com.inspirecoding.financeup.ui.typography.LTAsusFontFamily
import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_NUMBER_ONE
import com.inspirecoding.financeup.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import com.inspirecoding.financeup.util.enums.TextFieldState
import com.inspirecoding.financeup.util.secret.CustomSecretVisualTransformation
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusMicro
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusS
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusSm
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenSmall
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.finance_up_secret_eye_visible
import financeup.composeapp.generated.resources.finance_up_secret_eye_visible_off
import org.jetbrains.compose.resources.vectorResource

@Composable
fun DefaultTextField(
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    text: String,
    hintText: String = EMPTY_STRING_DEFAULT,
    label: String = EMPTY_STRING_DEFAULT,
    errorMessage: String = EMPTY_STRING_DEFAULT,
    textStyle: TextStyle = FinanceUpTypography.headlineSmall,
    maxLines: Int = KEY_NUMBER_ONE,
    modifier: Modifier = Modifier,
    state: TextFieldState = TextFieldState.DEFAULT,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onTextChange: (String) -> Unit
) {
    var isFocused by remember { mutableStateOf(false) }
    var mutableState = state

    val focusRequester = remember { FocusRequester() }

    TextField(
        value = text,
        shape = RoundedCornerShape(financeUpBorderRadiusSm),
        onValueChange = {
            mutableState = TextFieldState.DEFAULT
            onTextChange(it)
        },
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = financeUpBorderRadiusS,
                color = when (mutableState) {
                    TextFieldState.FILLED -> FinanceUpTheme.colorScheme.textField.border
                    TextFieldState.ERROR -> FinanceUpTheme.colorScheme.textField.error
                    TextFieldState.DEFAULT -> FinanceUpTheme.colorScheme.textField.border
                    TextFieldState.DISABLE -> FinanceUpTheme.colorScheme.textField.disable
                    TextFieldState.SUCCESS -> FinanceUpTheme.colorScheme.textField.border
                },
                shape = RoundedCornerShape(financeUpBorderRadiusSm)
            )
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            }
            .focusRequester(focusRequester),
        textStyle = textStyle,
        label = {
            Text(
                fontFamily = LTAsusFontFamily(),
                text = label,
                style = if (isFocused) FinanceUpTypography.labelMedium else FinanceUpTypography.headlineSmall,
                color = if (enabled) {
                    FinanceUpTheme.colorScheme.textField.label
                } else {
                    FinanceUpTheme.colorScheme.textField.disable
                }
            )
        },
        placeholder = {
            Text(
                fontFamily = LTAsusFontFamily(),
                text = hintText,
                style = FinanceUpTypography.headlineSmall,
                color = if (enabled) {
                    FinanceUpTheme.colorScheme.textField.placeholder
                } else {
                    FinanceUpTheme.colorScheme.textField.disable
                }
            )
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = FinanceUpTheme.colorScheme.textField.text,
            unfocusedTextColor = FinanceUpTheme.colorScheme.textField.text,
            disabledTextColor = FinanceUpTheme.colorScheme.textField.disable,
            focusedIndicatorColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent,
            cursorColor = FinanceUpTheme.colorScheme.textField.cursor
        ),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        maxLines = maxLines,
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        visualTransformation = visualTransformation
    )

    if ((mutableState == TextFieldState.ERROR && errorMessage.isNotEmpty())) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                fontFamily = LTAsusFontFamily(),
                modifier = Modifier.padding(top = financeUpDimenSmall, start = financeUpDimenLarge),
                text = errorMessage,
                color = FinanceUpTheme.colorScheme.textField.error,
                style = FinanceUpTypography.labelMedium,
            )
        }
    }
}

@Composable
fun InputTextField(
    text: String,
    hintText: String = EMPTY_STRING_DEFAULT,
    label: String = EMPTY_STRING_DEFAULT,
    errorMessage: String = EMPTY_STRING_DEFAULT,
    textStyle: TextStyle = FinanceUpTypography.headlineSmall,
    modifier: Modifier = Modifier,
    state: TextFieldState = TextFieldState.DEFAULT,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    isLoading: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onTextChange: (String) -> Unit
) {

    DefaultTextField(
        modifier = modifier,
        text = text,
        label = label,
        hintText = hintText,
        maxLines = KEY_NUMBER_ONE,
        errorMessage = errorMessage,
        textStyle = textStyle,
        singleLine = singleLine,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        enabled = enabled,
        visualTransformation = visualTransformation,
        onTextChange = { value ->
            onTextChange(value)
        },
        state = state,
        trailingIcon = {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(financeUpDimenLarge),
                    strokeWidth = financeUpBorderRadiusMicro,
                    color = Color.White
                )
            }
        }
    )
}

@Composable
fun SecretTextField(
    text: String,
    hintText: String = EMPTY_STRING_DEFAULT,
    label: String = EMPTY_STRING_DEFAULT,
    errorMessage: String = EMPTY_STRING_DEFAULT,
    textStyle: TextStyle = FinanceUpTypography.headlineSmall,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    state: TextFieldState = TextFieldState.DEFAULT,
    onTextChange: (String) -> Unit
) {

    var passwordVisible by remember { mutableStateOf(false) }

    DefaultTextField(
        modifier = modifier,
        text = text,
        label = label,
        hintText = hintText,
        maxLines = KEY_NUMBER_ONE,
        singleLine = singleLine,
        errorMessage = errorMessage,
        textStyle = textStyle,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        enabled = enabled,
        visualTransformation = if (passwordVisible) VisualTransformation.None else CustomSecretVisualTransformation(),
        onTextChange = { textSecret ->
            onTextChange(textSecret)
        },
        state = state,
        trailingIcon = {
            if (text.isNotEmpty()) {
                val image = if (passwordVisible)
                    vectorResource(resource = Res.drawable.finance_up_secret_eye_visible)
                else vectorResource(resource = Res.drawable.finance_up_secret_eye_visible_off)

                IconButton(
                    onClick = {
                        passwordVisible = !passwordVisible
                    },
                    content = {
                        Icon(
                            imageVector = image,
                            contentDescription = null,
                            tint = FinanceUpColorBaselineWhite
                        )
                    }
                )
            }
        }
    )
}