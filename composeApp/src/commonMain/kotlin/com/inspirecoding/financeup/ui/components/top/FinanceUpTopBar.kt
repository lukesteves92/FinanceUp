package com.inspirecoding.financeup.ui.components.top

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import com.inspirecoding.financeup.ui.theme.FinanceUpTheme
import com.inspirecoding.financeup.ui.typography.LTAsusFontFamily
import com.inspirecoding.financeup.util.constants.Constants.Text.EMPTY_STRING_DEFAULT
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimen2XLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimen3XsLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimen4XsLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpLineHeightTopBarText
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.finance_up_ic_arrow_left
import financeup.composeapp.generated.resources.finance_up_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun FinanceUpTopBar(
    modifier: Modifier = Modifier,
    isNavigation: Boolean = true,
    navigationIcon: Painter = painterResource(Res.drawable.finance_up_ic_arrow_left),
    navigationText: String = EMPTY_STRING_DEFAULT,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(financeUpDimen4XsLarge)
    ) {
        if (isNavigation) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onClick,
                    content = {
                        Icon(
                            painter = navigationIcon,
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                )

                Text(
                    fontFamily = LTAsusFontFamily(),
                    text = navigationText,
                    style = TextStyle(
                        lineHeight = financeUpLineHeightTopBarText,
                        color = FinanceUpTheme.colorScheme.text.color
                    )
                )
            }
        }

        Image(
            painter = painterResource(Res.drawable.finance_up_logo),
            contentDescription = null,
            modifier = Modifier
                .height(financeUpDimen4XsLarge)
                .align(Alignment.Center)
        )
    }
}