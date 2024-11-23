package com.inspirecoding.financeup.ui.typography

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.inspirecoding.financeup.ui.color.FinanceUpColorBaselineText
import financeup.composeapp.generated.resources.Res
import financeup.composeapp.generated.resources.asus_bold
import financeup.composeapp.generated.resources.asus_bold_italic
import financeup.composeapp.generated.resources.asus_light
import financeup.composeapp.generated.resources.asus_light_italic
import financeup.composeapp.generated.resources.asus_regular
import org.jetbrains.compose.resources.Font

@Composable
fun LTAsusFontFamily(): FontFamily {
    return FontFamily(
        Font(resource = Res.font.asus_bold, weight = FontWeight.Bold, style = FontStyle.Normal),
        Font(resource = Res.font.asus_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
        Font(resource = Res.font.asus_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
        Font(resource = Res.font.asus_light, weight = FontWeight.Light, style = FontStyle.Normal),
        Font(resource = Res.font.asus_light_italic, weight = FontWeight.Medium, style = FontStyle.Italic)
    )
}


val FinanceUpTypography = Typography(
    displayLarge = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 56.sp,
        color = FinanceUpColorBaselineText
    ),
    displayMedium = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        color = FinanceUpColorBaselineText
    ),
    displaySmall = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        color = FinanceUpColorBaselineText
    ),
    headlineLarge = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = FinanceUpColorBaselineText
    ),
    headlineMedium = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = FinanceUpColorBaselineText
    ),
    headlineSmall = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = FinanceUpColorBaselineText
    ),
    titleLarge = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        color = FinanceUpColorBaselineText
    ),
    titleMedium = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = FinanceUpColorBaselineText
    ),
    titleSmall = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = FinanceUpColorBaselineText
    ),
    bodyLarge = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Light,
        fontSize = 32.sp,
        color = FinanceUpColorBaselineText
    ),
    bodyMedium = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Light,
        fontSize = 24.sp,
        color = FinanceUpColorBaselineText
    ),
    bodySmall = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        color = FinanceUpColorBaselineText
    ),
    // Caption
    labelLarge = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        color = FinanceUpColorBaselineText
    ),
    labelMedium = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
        color = FinanceUpColorBaselineText
    )
)