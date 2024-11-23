package com.inspirecoding.financeup.features.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.inspirecoding.financeup.extensions.formatCurrency
import com.inspirecoding.financeup.extensions.toPercentage
import com.inspirecoding.financeup.ui.color.BudgetProgressBarBackgroundColor
import com.inspirecoding.financeup.ui.components.background.FinanceUpDefaultBackground
import com.inspirecoding.financeup.ui.components.budget.BudgetProgressBar
import com.inspirecoding.financeup.ui.components.button.FloatingButtonUI
import com.inspirecoding.financeup.ui.components.top.FinanceUpTopBar
import com.inspirecoding.financeup.ui.typography.FinanceUpTypography
import com.inspirecoding.financeup.ui.typography.LTAsusFontFamily
import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_DURATION_ANIMATION_PROGRESS_MIN
import com.inspirecoding.financeup.util.constants.Constants.ProgressConstants.MAX_PROGRESS
import com.inspirecoding.financeup.util.constants.Constants.ProgressConstants.MIN_PROGRESS
import com.inspirecoding.financeup.util.variables.Variables.financeUpBorderRadiusSm
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenLarge
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenSmall
import com.inspirecoding.financeup.util.variables.Variables.financeUpDimenSmallMedium
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.message_password_invalid_format
import financeup.composeapp.generated.resources.text_budget_component_title
import financeup.composeapp.generated.resources.text_budget_component_title_over
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeScreen() {
    HomeContent()
}

@Composable
fun HomeContent() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = {
            FinanceUpTopBar()
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .padding(financeUpDimenLarge)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                FloatingButtonUI(
                    isLess = true,
                    onClick = {}
                )

                FloatingButtonUI(
                    isAdd = true,
                    onClick = {}
                )
            }
        },
        floatingActionButton = {},
        content = { paddingValues ->

            FinanceUpDefaultBackground()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BudgetProgressBarExample()
            }
        }
    )
}

@Composable
fun BudgetProgressBarExample() {
    val totalBudget = remember { mutableStateOf(8000f) }
    val spentAmount = remember { mutableStateOf(8100f) }

    BudgetProgressBar(
        budget = totalBudget.value.formatCurrency(),
        spentAmount = { spentAmount.value },
        totalBudget = { totalBudget.value }
    )
}


