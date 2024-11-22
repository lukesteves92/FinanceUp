package com.inspirecoding.financeup.util.secret

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import com.inspirecoding.financeup.util.constants.Constants.Numbers.KEY_NUMBER_TWO

class CustomSecretVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val maskChar = "● "
        val maskedText = buildAnnotatedString {
            repeat(text.length) {
                append(maskChar)
            }
        }

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return offset * KEY_NUMBER_TWO
            }

            override fun transformedToOriginal(offset: Int): Int {
                return offset / KEY_NUMBER_TWO
            }
        }

        return TransformedText(
            maskedText,
            offsetMapping
        )
    }
}