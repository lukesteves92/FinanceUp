package com.inspirecoding.financeup.util.enums.expensetype

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

enum class ExpenseType(val icon: ImageVector) {
    FOOD(Icons.Rounded.ShoppingCart),
    SHOPPING(Icons.Rounded.ShoppingCart),
    RENT(Icons.Rounded.Home),
    LEISURE(Icons.Rounded.Place),
    OTHERS(Icons.Rounded.MoreVert)
}