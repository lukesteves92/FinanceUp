package com.inspirecoding.financeup.ui.components.indicator

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.util.Constants.Numbers.KEY_DURATION_ANIMATION_MIN
import com.inspirecoding.financeup.util.Constants.Numbers.KEY_NUMBER_ONE
import com.inspirecoding.financeup.util.Constants.Text.EMPTY_STRING_DEFAULT
import com.inspirecoding.financeup.util.Variables.financeUpDimenExtraSmall
import com.inspirecoding.financeup.util.Variables.financeUpDimenMedium
import com.inspirecoding.financeup.util.Variables.financeUpDimenSmall
import com.inspirecoding.financeup.util.Variables.financeUpOpacity10Percent
import com.inspirecoding.financeup.util.Variables.financeUpOpacity70Percent

@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    indicatorSize: Int,
    currentIndicator: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(indicatorSize) { index ->
            val currentIndex = index + KEY_NUMBER_ONE
            val checked = currentIndicator == currentIndex
            val color = if (checked) {
                FinanceUpTheme.colorScheme.pagerIndicator.activeBackground
            } else {
                FinanceUpTheme.colorScheme.pagerIndicator.inactiveBackground
            }

            val animatedWeight by animateFloatAsState(
                targetValue = if (currentIndex == currentIndicator) financeUpOpacity70Percent else financeUpOpacity10Percent,
                animationSpec = tween(durationMillis = KEY_DURATION_ANIMATION_MIN),
                label = EMPTY_STRING_DEFAULT
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(financeUpDimenExtraSmall)
                    .clip(shape = RoundedCornerShape(financeUpDimenMedium))
                    .background(color = color)
                    .weight(animatedWeight)
            )

            if (currentIndex < indicatorSize) {
                Spacer(modifier = Modifier.width(financeUpDimenSmall))
            }
        }
    }
}