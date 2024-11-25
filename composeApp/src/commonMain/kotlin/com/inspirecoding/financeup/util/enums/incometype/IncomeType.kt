package com.inspirecoding.financeup.util.enums.incometype

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

enum class IncomeType(val icon: ImageVector, val id: String) {
    SALARY(Icons.Rounded.ThumbUp, "salary"),
    EARNINGS(Icons.Rounded.ThumbUp, "earnings"),
    OTHERS(Icons.Rounded.MoreVert, "others");

    companion object {
        fun fromId(id: String): IncomeType {
            return entries.find { it.id == id } ?: OTHERS
        }
    }
}