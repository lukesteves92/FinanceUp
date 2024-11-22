package com.inspirecoding.financeup.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import com.inspirecoding.financeup.ui.color.BottomSheetBackgroundColor
import com.inspirecoding.financeup.ui.color.BottomSheetDragHandleColor
import com.inspirecoding.financeup.ui.color.OutlineButtonBackgroundColor
import com.inspirecoding.financeup.ui.color.OutlineButtonBorderColor
import com.inspirecoding.financeup.ui.color.OutlineButtonTextColor
import com.inspirecoding.financeup.ui.color.PagerIndicatorActiveBackgroundColor
import com.inspirecoding.financeup.ui.color.PagerIndicatorInactiveBackgroundColor
import com.inspirecoding.financeup.ui.color.ScreenBackgroundColor
import com.inspirecoding.financeup.ui.color.SolidButtonBackgroundColor
import com.inspirecoding.financeup.ui.color.SolidButtonContentColor
import com.inspirecoding.financeup.ui.color.TextColor
import com.inspirecoding.financeup.ui.color.TextFieldBorderColor
import com.inspirecoding.financeup.ui.color.TextFieldCursorColor
import com.inspirecoding.financeup.ui.color.TextFieldDisableColor
import com.inspirecoding.financeup.ui.color.TextFieldErrorColor
import com.inspirecoding.financeup.ui.color.TextFieldLabelColor
import com.inspirecoding.financeup.ui.color.TextFieldPlaceholderColor
import com.inspirecoding.financeup.ui.color.TextFieldTextColor
import com.inspirecoding.financeup.ui.color.FloatingActionButtonBackgroundColor
import com.inspirecoding.financeup.ui.color.FloatingActionButtonContentColor
import com.inspirecoding.financeup.ui.color.FloatingActionButtonLoadingColor
import com.inspirecoding.financeup.ui.scheme.MyColorScheme
import com.inspirecoding.financeup.ui.scheme.sheet.BottomSheetColorScheme
import com.inspirecoding.financeup.ui.scheme.button.OutlineButtonColorScheme
import com.inspirecoding.financeup.ui.scheme.button.SolidButtonColorScheme
import com.inspirecoding.financeup.ui.scheme.button.FloatingButtonColorScheme
import com.inspirecoding.financeup.ui.scheme.indicator.PagerIndicatorColorScheme
import com.inspirecoding.financeup.ui.scheme.input.TextFieldColorScheme
import com.inspirecoding.financeup.ui.scheme.screen.ScreenColorScheme
import com.inspirecoding.financeup.ui.scheme.text.TextColorScheme

val DefaultColorScheme = MyColorScheme(
    floatingButton = FloatingButtonColorScheme(
        container = FloatingActionButtonBackgroundColor,
        content = FloatingActionButtonContentColor,
        loading = FloatingActionButtonLoadingColor
    ),
    outlineButton = OutlineButtonColorScheme(
        container = OutlineButtonBackgroundColor,
        border = OutlineButtonBorderColor,
        text = OutlineButtonTextColor,
    ),
    solidButton = SolidButtonColorScheme(
        container = SolidButtonBackgroundColor,
        content = SolidButtonContentColor
    ),
    pagerIndicator = PagerIndicatorColorScheme(
        activeBackground = PagerIndicatorActiveBackgroundColor,
        inactiveBackground = PagerIndicatorInactiveBackgroundColor
    ),
    text = TextColorScheme(
        color = TextColor
    ),
    textField = TextFieldColorScheme(
        text = TextFieldTextColor,
        label = TextFieldLabelColor,
        placeholder = TextFieldPlaceholderColor,
        border = TextFieldBorderColor,
        error = TextFieldErrorColor,
        disable = TextFieldDisableColor,
        cursor = TextFieldCursorColor
    ),
    screen = ScreenColorScheme(
        background = ScreenBackgroundColor
    ),
    sheet = BottomSheetColorScheme(
        background = BottomSheetBackgroundColor,
        dragHandle = BottomSheetDragHandleColor
    )
)

private val LocalColorScheme = compositionLocalOf { DefaultColorScheme }

object FinanceUpTheme {
    val colorScheme: MyColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current
}

@Composable
fun FinanceUpTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalColorScheme provides DefaultColorScheme) {
        MaterialTheme(
            content = content
        )
    }
}