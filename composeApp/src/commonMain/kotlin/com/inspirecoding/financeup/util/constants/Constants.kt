package com.inspirecoding.financeup.util.constants

object Constants {

    object Text {
        const val EMPTY_STRING_DEFAULT = ""
        const val EMPTY_SPACE_DEFAULT = " "
    }

    object Numbers {
        const val KEY_NUMBER_ZERO = 0
        const val KEY_NUMBER_ZERO_LONG: Long = 0
        const val KEY_NUMBER_ONE = 1
        const val KEY_NUMBER_TWO = 2
        const val KEY_NUMBER_THREE = 3
        const val KEY_NUMBER_FOUR = 4
        const val KEY_NUMBER_SIX = 6
        const val KEY_NUMBER_FIVE = 5
        const val KEY_NUMBER_EIGHT = 8
        const val KEY_DURATION_CURRENT_STEP_MIN: Long = 100
        const val KEY_DURATION_ANIMATION_MIN = 500
        const val KEY_TOAST_DURATION_MAX: Long = 5000
        const val KEY_DURATION_ANIMATION_PROGRESS_MIN = 1000
    }

    object ProgressConstants {
        const val MAX_PROGRESS = 1f
        const val MIN_PROGRESS = 0f
    }

    object DataBase {
        const val FINANCE_UP_DATABASE = "finance_up_app.db"

        // Income Table
        const val INCOME_TABLE = "income_table"
        const val ID_COLUMN_INCOME_TABLE = "id"
        const val NAME_COLUMN_INCOME_TABLE = "name"
        const val AMOUNT_COLUMN_INCOME_TABLE = "amount"
        const val TYPE_COLUMN_INCOME_TABLE = "type"
        const val RECEIVED_DATE_COLUMN_INCOME_TABLE = "received_date"

        // Spending Table
        const val SPENDING_TABLE = "spending_table"
        const val ID_COLUMN_SPENDING_TABLE = "id"
        const val NAME_COLUMN_SPENDING_TABLE = "name"
        const val AMOUNT_COLUMN_SPENDING_TABLE = "amount"
        const val TYPE_COLUMN_SPENDING_TABLE = "type"
        const val PURCHASE_DATE_COLUMN_SPENDING_TABLE = "purchase_date"
    }

}