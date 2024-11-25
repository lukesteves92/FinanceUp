package com.inspirecoding.financeup.util.enums.expensetype

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

enum class ExpenseType(val icon: ImageVector, val id: String) {
    FOOD(Icons.Rounded.ShoppingCart, "food"),
    SHOPPING(Icons.Rounded.ShoppingCart, "shopping"),
    RENT(Icons.Rounded.Home, "rent"),
    LEISURE(Icons.Rounded.Place, "leisure"),
    OTHERS(Icons.Rounded.MoreVert, "others");

    companion object {
        fun fromId(id: String): ExpenseType {
            return entries.find { it.id == id } ?: OTHERS
        }
    }
}