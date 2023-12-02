package com.aradevs.pokeapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.aradevs.pokeapp.R
import com.aradevs.pokeapp.R.font.montserrat_italic

// Set of Material typography styles to start with
object AppFont {
    val Montserrat = FontFamily(
        Font(R.font.montserrat_regular),
        Font(montserrat_italic, style = FontStyle.Italic),
        Font(R.font.montserrat_medium, FontWeight.Medium),
        Font(R.font.montserrat_mediumitalic, FontWeight.Medium, style = FontStyle.Italic),
        Font(R.font.montserrat_bold, FontWeight.Bold),
        Font(R.font.montserrat_blackitalic, FontWeight.Bold, style = FontStyle.Italic)
    )
}

private val defaultTypography = Typography()

val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = AppFont.Montserrat),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = AppFont.Montserrat),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = AppFont.Montserrat),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = AppFont.Montserrat),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = AppFont.Montserrat),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = AppFont.Montserrat),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = AppFont.Montserrat),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = AppFont.Montserrat),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = AppFont.Montserrat),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = AppFont.Montserrat),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = AppFont.Montserrat),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = AppFont.Montserrat),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = AppFont.Montserrat),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = AppFont.Montserrat),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = AppFont.Montserrat)
)