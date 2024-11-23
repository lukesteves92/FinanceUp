package com.inspirecoding.financeup.util.enums.incometype

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

enum class IncomeType(val icon: ImageVector) {
    SALARY(Icons.Rounded.ThumbUp),
    EARNINGS(Icons.Rounded.ThumbUp),
    OTHERS(Icons.Rounded.MoreVert)
}