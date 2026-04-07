package io.github.onlyashd.bunny.ui.theme.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

class GreenTheme {
    private val primaryLight = Color(0xFF5B631D)
    private val onPrimaryLight = Color(0xFFFFFFFF)
    private val primaryContainerLight = Color(0xFFE0E994)
    private val onPrimaryContainerLight = Color(0xFF444B05)
    private val secondaryLight = Color(0xFF5E6144)
    private val onSecondaryLight = Color(0xFFFFFFFF)
    private val secondaryContainerLight = Color(0xFFE3E5C1)
    private val onSecondaryContainerLight = Color(0xFF46492E)
    private val tertiaryLight = Color(0xFF3B665A)
    private val onTertiaryLight = Color(0xFFFFFFFF)
    private val tertiaryContainerLight = Color(0xFFBEECDD)
    private val onTertiaryContainerLight = Color(0xFF234E43)
    private val errorLight = Color(0xFFBA1A1A)
    private val onErrorLight = Color(0xFFFFFFFF)
    private val errorContainerLight = Color(0xFFFFDAD6)
    private val onErrorContainerLight = Color(0xFF93000A)
    private val backgroundLight = Color(0xFFFCFAED)
    private val onBackgroundLight = Color(0xFF1C1C14)
    private val surfaceLight = Color(0xFFFCFAED)
    private val onSurfaceLight = Color(0xFF1C1C14)
    private val surfaceVariantLight = Color(0xFFE4E3D2)
    private val onSurfaceVariantLight = Color(0xFF47483B)
    private val outlineLight = Color(0xFF78786A)
    private val outlineVariantLight = Color(0xFFC8C7B7)
    private val scrimLight = Color(0xFF000000)
    private val inverseSurfaceLight = Color(0xFF313128)
    private val inverseOnSurfaceLight = Color(0xFFF3F1E4)
    private val inversePrimaryLight = Color(0xFFC4CD7B)
    private val surfaceDimLight = Color(0xFFDCDACE)
    private val surfaceBrightLight = Color(0xFFFCFAED)
    private val surfaceContainerLowestLight = Color(0xFFFFFFFF)
    private val surfaceContainerLowLight = Color(0xFFF6F4E7)
    private val surfaceContainerLight = Color(0xFFF0EEE1)
    private val surfaceContainerHighLight = Color(0xFFEAE8DC)
    private val surfaceContainerHighestLight = Color(0xFFE5E3D6)

    private val primaryDark = Color(0xFFC4CD7B)
    private val onPrimaryDark = Color(0xFF2E3300)
    private val primaryContainerDark = Color(0xFF444B05)
    private val onPrimaryContainerDark = Color(0xFFE0E994)
    private val secondaryDark = Color(0xFFC7C9A7)
    private val onSecondaryDark = Color(0xFF30321A)
    private val secondaryContainerDark = Color(0xFF46492E)
    private val onSecondaryContainerDark = Color(0xFFE3E5C1)
    private val tertiaryDark = Color(0xFFA2D0C1)
    private val onTertiaryDark = Color(0xFF06372D)
    private val tertiaryContainerDark = Color(0xFF234E43)
    private val onTertiaryContainerDark = Color(0xFFBEECDD)
    private val errorDark = Color(0xFFFFB4AB)
    private val onErrorDark = Color(0xFF690005)
    private val errorContainerDark = Color(0xFF93000A)
    private val onErrorContainerDark = Color(0xFFFFDAD6)
    private val backgroundDark = Color(0xFF13140D)
    private val onBackgroundDark = Color(0xFFE5E3D6)
    private val surfaceDark = Color(0xFF13140D)
    private val onSurfaceDark = Color(0xFFE5E3D6)
    private val surfaceVariantDark = Color(0xFF47483B)
    private val onSurfaceVariantDark = Color(0xFFC8C7B7)
    private val outlineDark = Color(0xFF929282)
    private val outlineVariantDark = Color(0xFF47483B)
    private val scrimDark = Color(0xFF000000)
    private val inverseSurfaceDark = Color(0xFFE5E3D6)
    private val inverseOnSurfaceDark = Color(0xFF313128)
    private val inversePrimaryDark = Color(0xFF5B631D)
    private val surfaceDimDark = Color(0xFF13140D)
    private val surfaceBrightDark = Color(0xFF393A31)
    private val surfaceContainerLowestDark = Color(0xFF0E0F08)
    private val surfaceContainerLowDark = Color(0xFF1C1C14)
    private val surfaceContainerDark = Color(0xFF202018)
    private val surfaceContainerHighDark = Color(0xFF2A2B22)
    private val surfaceContainerHighestDark = Color(0xFF35352D)

    private val lightScheme = lightColorScheme(
        primary = primaryLight,
        onPrimary = onPrimaryLight,
        primaryContainer = primaryContainerLight,
        onPrimaryContainer = onPrimaryContainerLight,
        secondary = secondaryLight,
        onSecondary = onSecondaryLight,
        secondaryContainer = secondaryContainerLight,
        onSecondaryContainer = onSecondaryContainerLight,
        tertiary = tertiaryLight,
        onTertiary = onTertiaryLight,
        tertiaryContainer = tertiaryContainerLight,
        onTertiaryContainer = onTertiaryContainerLight,
        error = errorLight,
        onError = onErrorLight,
        errorContainer = errorContainerLight,
        onErrorContainer = onErrorContainerLight,
        background = backgroundLight,
        onBackground = onBackgroundLight,
        surface = surfaceLight,
        onSurface = onSurfaceLight,
        surfaceVariant = surfaceVariantLight,
        onSurfaceVariant = onSurfaceVariantLight,
        outline = outlineLight,
        outlineVariant = outlineVariantLight,
        scrim = scrimLight,
        inverseSurface = inverseSurfaceLight,
        inverseOnSurface = inverseOnSurfaceLight,
        inversePrimary = inversePrimaryLight,
        surfaceDim = surfaceDimLight,
        surfaceBright = surfaceBrightLight,
        surfaceContainerLowest = surfaceContainerLowestLight,
        surfaceContainerLow = surfaceContainerLowLight,
        surfaceContainer = surfaceContainerLight,
        surfaceContainerHigh = surfaceContainerHighLight,
        surfaceContainerHighest = surfaceContainerHighestLight,
    )

    private val darkScheme = darkColorScheme(
        primary = primaryDark,
        onPrimary = onPrimaryDark,
        primaryContainer = primaryContainerDark,
        onPrimaryContainer = onPrimaryContainerDark,
        secondary = secondaryDark,
        onSecondary = onSecondaryDark,
        secondaryContainer = secondaryContainerDark,
        onSecondaryContainer = onSecondaryContainerDark,
        tertiary = tertiaryDark,
        onTertiary = onTertiaryDark,
        tertiaryContainer = tertiaryContainerDark,
        onTertiaryContainer = onTertiaryContainerDark,
        error = errorDark,
        onError = onErrorDark,
        errorContainer = errorContainerDark,
        onErrorContainer = onErrorContainerDark,
        background = backgroundDark,
        onBackground = onBackgroundDark,
        surface = surfaceDark,
        onSurface = onSurfaceDark,
        surfaceVariant = surfaceVariantDark,
        onSurfaceVariant = onSurfaceVariantDark,
        outline = outlineDark,
        outlineVariant = outlineVariantDark,
        scrim = scrimDark,
        inverseSurface = inverseSurfaceDark,
        inverseOnSurface = inverseOnSurfaceDark,
        inversePrimary = inversePrimaryDark,
        surfaceDim = surfaceDimDark,
        surfaceBright = surfaceBrightDark,
        surfaceContainerLowest = surfaceContainerLowestDark,
        surfaceContainerLow = surfaceContainerLowDark,
        surfaceContainer = surfaceContainerDark,
        surfaceContainerHigh = surfaceContainerHighDark,
        surfaceContainerHighest = surfaceContainerHighestDark,
    )

    companion object {
        val lightScheme = GreenTheme().lightScheme
        val darkScheme = GreenTheme().darkScheme
        val sample = GreenTheme().primaryLight
    }
}