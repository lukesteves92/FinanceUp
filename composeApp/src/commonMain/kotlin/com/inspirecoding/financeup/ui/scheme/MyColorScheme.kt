package com.inspirecoding.financeup.ui.scheme

import com.inspirecoding.financeup.ui.scheme.sheet.BottomSheetColorScheme
import com.inspirecoding.financeup.ui.scheme.button.FloatingButtonColorScheme
import com.inspirecoding.financeup.ui.scheme.button.OutlineButtonColorScheme
import com.inspirecoding.financeup.ui.scheme.button.SolidButtonColorScheme
import com.inspirecoding.financeup.ui.scheme.indicator.PagerIndicatorColorScheme
import com.inspirecoding.financeup.ui.scheme.input.TextFieldColorScheme
import com.inspirecoding.financeup.ui.scheme.screen.ScreenColorScheme
import com.inspirecoding.financeup.ui.scheme.text.TextColorScheme

data class MyColorScheme(
    val floatingButton: FloatingButtonColorScheme,
    val outlineButton: OutlineButtonColorScheme,
    val solidButton: SolidButtonColorScheme,
    val pagerIndicator: PagerIndicatorColorScheme,
    val text: TextColorScheme,
    val textField: TextFieldColorScheme,
    val screen: ScreenColorScheme,
    val sheet: BottomSheetColorScheme
)
